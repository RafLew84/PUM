package pl.udu.uwr.pum.shoppykotlin.fragments.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import pl.udu.uwr.pum.shoppykotlin.R
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

        itemViewModel.readAllData.observe(viewLifecycleOwner) { items ->
            items?.let { adapter.submitList(it) }
        }

        binding.addItemFAB.setOnClickListener {
            findNavController().navigate(ListFragmentDirections.actionListFragmentToAddFragment())
        }
    }
}