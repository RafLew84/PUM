package pl.udu.uwr.pum.foody.ui.foodlist

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import pl.udu.uwr.pum.foody.adapters.FoodAdapter
import pl.udu.uwr.pum.foody.adapters.FoodComparator
import pl.udu.uwr.pum.foody.databinding.FragmentFoodListBinding
import pl.udu.uwr.pum.foody.ui.FoodViewModel
import pl.udu.uwr.pum.foody.util.Resource

class FoodListFragment : Fragment() {
    private lateinit var binding: FragmentFoodListBinding

    private val foodViewModel: FoodViewModel by activityViewModels()
    private val TAG = "FoodListFragment"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFoodListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        foodViewModel.getMealList()

        val adapter = FoodAdapter(FoodComparator())
        setupRecyclerView(adapter)

        observeFood(adapter)
    }

    private fun hideProgressBar(){
        binding.progressBar.visibility = View.INVISIBLE
    }

    private fun showProgressBar(){
        binding.progressBar.visibility = View.VISIBLE
    }

    private fun setupRecyclerView(foodAdapter: FoodAdapter) {
        binding.foodRV.apply {
            adapter = foodAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }

    private fun observeFood(foodAdapter: FoodAdapter) {
        foodViewModel.mealList.observe(viewLifecycleOwner) { response ->
            when (response) {
                is Resource.Success -> {
                    hideProgressBar()
                    response.data?.let { res ->
                        foodAdapter.submitList(res.meals)
                    }
                }
                is Resource.Error -> {
                    hideProgressBar()
                    response.message?.let { Log.e(TAG, "Error occurred: $it") }
                }
                is Resource.Loading -> showProgressBar()
            }
        }
    }
}