package pl.udu.uwr.pum.shoppykotlin.fragments.update

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import pl.udu.uwr.pum.shoppykotlin.R
import pl.udu.uwr.pum.shoppykotlin.databinding.FragmentListBinding
import pl.udu.uwr.pum.shoppykotlin.databinding.FragmentUpdateBinding
import pl.udu.uwr.pum.shoppykotlin.fragments.add.AddFragmentDirections
import pl.udu.uwr.pum.shoppykotlin.model.Item
import pl.udu.uwr.pum.shoppykotlin.viewmodel.ItemViewModel

class UpdateFragment : Fragment() {

    private lateinit var binding: FragmentUpdateBinding

    private val itemViewModel: ItemViewModel by viewModels()

    private val itemId: Int by lazy { requireArguments().getInt("id") }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentUpdateBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        itemViewModel.getItem(itemId).observe(viewLifecycleOwner, this::displayItem)

        binding.updateButton.setOnClickListener { updateItem() }
    }

    private fun displayItem(item: Item){
        binding.nameEditText.setText(item.name)
        binding.quantityEditText.setText(item.quantity.toString())
    }

    private fun updateItem() {
        val name = binding.nameEditText.text.toString()
        val quantity = binding.quantityEditText.text.toString()

        if (name.isNotEmpty() && quantity.isNotEmpty()){
            val item = Item(itemId, name, quantity.toInt())
            itemViewModel.updateItem(item)
            findNavController().navigate(UpdateFragmentDirections.actionUpdateFragmentToListFragment())
        } else{
            binding.nameEditText.error = "Podaj nazwę"
            binding.quantityEditText.error = "Podaj ilość"
        }
    }
}