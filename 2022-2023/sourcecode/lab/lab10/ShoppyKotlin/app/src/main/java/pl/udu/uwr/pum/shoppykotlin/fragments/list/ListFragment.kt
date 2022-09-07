package pl.udu.uwr.pum.shoppykotlin.fragments.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import pl.udu.uwr.pum.shoppykotlin.databinding.FragmentListBinding
import pl.udu.uwr.pum.shoppykotlin.viewmodel.ItemViewModel

class ListFragment : Fragment() {

    private lateinit var binding: FragmentListBinding

    private val itemViewModel: ItemViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = ItemAdapter(ItemComparator())
        binding.listRecyclerView.adapter = adapter
        binding.listRecyclerView.layoutManager = LinearLayoutManager(requireContext())

        itemViewModel.readAllData.observe(viewLifecycleOwner, adapter::submitList)

        binding.addItemFAB.setOnClickListener {
            findNavController().navigate(ListFragmentDirections.actionListFragmentToAddFragment())
        }

        swipeToDelete(adapter)

        binding.clearDataFAB.setOnClickListener {
            deleteAll()
        }

        setupSearchView(adapter)
    }

    private fun setupSearchView(adapter: ItemAdapter) {
        binding.searchSearchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                if (query != null) search(query, adapter)
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if (newText != null) search(newText, adapter)
                return true
            }

        })
    }

    private fun search(query: String, adapter: ItemAdapter){
        val searchQuery = "%$query%"

        itemViewModel.searchItem(searchQuery).observe(viewLifecycleOwner, adapter::submitList)
    }

    private fun deleteAll() {
        itemViewModel.deleteAll()
    }

    private fun swipeToDelete(adapter: ItemAdapter) {
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
                itemViewModel.deleteItem(adapter.getItemAt(viewHolder.adapterPosition))
            }
        }).attachToRecyclerView(binding.listRecyclerView)
    }
}