package pl.udu.uwr.pum.verynobleappkotlin.ui.fragments.laureate

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import pl.udu.uwr.pum.verynobleappkotlin.R
import pl.udu.uwr.pum.verynobleappkotlin.adapters.nobleprizelaureate.LaureateAdapter
import pl.udu.uwr.pum.verynobleappkotlin.data.laureateresponse.LaureateResponseItem
import pl.udu.uwr.pum.verynobleappkotlin.databinding.FragmentLaureateBinding
import pl.udu.uwr.pum.verynobleappkotlin.databinding.FragmentNobelAwardBinding
import pl.udu.uwr.pum.verynobleappkotlin.ui.fragments.nobelaward.NobelPrizeViewModel
import pl.udu.uwr.pum.verynobleappkotlin.util.Resource

class LaureateFragment : Fragment() {
    private lateinit var binding: FragmentLaureateBinding

    private val laureateViewModel: LaureateViewModel by viewModels()
    private val TAG = "LaureateFragment"

    private val id: String? by lazy { requireArguments().getString("id") }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLaureateBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        laureateViewModel.getLaureate(id!!)
        observeLaureatePrize()
    }

    private fun hideProgressBar(){
        binding.laureateProgressBar.visibility = View.INVISIBLE
    }

    private fun showProgressBar(){
        binding.laureateProgressBar.visibility = View.VISIBLE
    }

    private fun observeLaureatePrize() {
        laureateViewModel.laureate.observe(viewLifecycleOwner) { response ->
            when (response) {
                is Resource.Success -> {
                    hideProgressBar()
                    response.data?.let {
                        inflateLayoutWithDate(it[0])
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

    private fun inflateLayoutWithDate(item: LaureateResponseItem){
        binding.fullNameTextView.text = item.fullName.en
        binding.birthDateTextView.text = item.birth.date
        binding.birthCityTextView.text = item.birth.place.city.en
        binding.birthCountryTextView.text = item.birth.place.country.en
        binding.deathDateTextView.text = item.death?.date?:""
        binding.deathCityTextView.text = item.death?.place?.city?.en?:""
        binding.deathCountryTextView.text = item.death?.place?.country?.en?:""
    }
}