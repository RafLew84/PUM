package pl.udu.uwr.pum.foody.ui.favorite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import pl.udu.uwr.pum.foody.adapters.FoodAdapter
import pl.udu.uwr.pum.foody.adapters.FoodComparator
import pl.udu.uwr.pum.foody.databinding.FragmentFavoriteBinding
import pl.udu.uwr.pum.foody.ui.FoodViewModel

class FavoriteFragment : Fragment() {

    private lateinit var binding: FragmentFavoriteBinding

    private val foodViewModel: FoodViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFavoriteBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = FoodAdapter(FoodComparator())
        setupRecyclerView(adapter)
        foodViewModel.readAllData.observe(viewLifecycleOwner, adapter::submitList)
        swipeToDelete(adapter)
    }

    private fun setupRecyclerView(foodAdapter: FoodAdapter) {
        binding.favoriteRV.apply {
            adapter = foodAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }

    private fun swipeToDelete(adapter: FoodAdapter) {
        ItemTouchHelper(object : ItemTouchHelper.SimpleCallback(
            0,
            ItemTouchHelper.RIGHT or ItemTouchHelper.LEFT
        ) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                foodViewModel.delete(adapter.getItemAt(viewHolder.adapterPosition))
            }
        }).attachToRecyclerView(binding.favoriteRV)
    }
}