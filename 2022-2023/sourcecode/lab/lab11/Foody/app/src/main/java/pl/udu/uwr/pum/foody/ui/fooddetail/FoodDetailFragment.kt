package pl.udu.uwr.pum.foody.ui.fooddetail

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import pl.udu.uwr.pum.foody.data.Meal
import pl.udu.uwr.pum.foody.databinding.FragmentFoodDetailBinding
import pl.udu.uwr.pum.foody.ui.FoodViewModel
import pl.udu.uwr.pum.foody.util.Resource

class FoodDetailFragment : Fragment() {

    private lateinit var binding: FragmentFoodDetailBinding

    private val foodViewModel: FoodViewModel by activityViewModels()
    private val TAG = "FoodDetailFragment"

    private val id: String? by lazy { requireArguments().getString("id") }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFoodDetailBinding.inflate(layoutInflater, container, false)
        foodViewModel.getMealById(id!!)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        foodViewModel.meal.observe(viewLifecycleOwner){response ->
            when (response) {
                is Resource.Success -> {
                    hideProgressBar()
                    response.data?.let { res ->
                        val item = res.meals.first()
                        inflate(item)
                        binding.favoriteButton.setOnClickListener {
                            foodViewModel.insert(item)
                        }
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

    private fun inflate(item: Meal) {
        Glide.with(this)
            .load(item.strMealThumb)
            .into(binding.foodImage)
        binding.category.text = item.strCategory
        binding.title.text = item.strMeal
        binding.instructions.text = item.strInstructions
    }

    private fun hideProgressBar(){
        binding.progressBar.visibility = View.INVISIBLE
    }

    private fun showProgressBar(){
        binding.progressBar.visibility = View.VISIBLE
    }
}