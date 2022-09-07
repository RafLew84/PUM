package pl.udu.uwr.pum.shoppykotlin.fragments.add

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import pl.udu.uwr.pum.shoppykotlin.data.Item
import pl.udu.uwr.pum.shoppykotlin.viewmodel.ItemViewModel
import pl.udu.uwr.pum.shoppykotlin.databinding.FragmentAddBinding

class AddFragment : Fragment() {

    private lateinit var binding: FragmentAddBinding

    private val itemViewModel: ItemViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.saveButton.setOnClickListener {
            insertToDatabase()
        }
    }

    private fun insertToDatabase() {
        val name = binding.nameEditText.text.toString()
        val quantity = binding.quantityEditText.text.toString()

        if (name.isNotEmpty() && quantity.isNotEmpty()){
            val item = Item(0, name, quantity.toInt())
            itemViewModel.addItem(item)
            findNavController().navigate(AddFragmentDirections.actionAddFragmentToListFragment())
        } else{
            binding.nameEditText.error = "Podaj nazwę"
            binding.quantityEditText.error = "Podaj ilość"
        }
    }
}