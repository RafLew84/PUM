package pl.udu.uwr.pum.verynobleappkotlin.ui.fragments.nobleawards

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import pl.udu.uwr.pum.verynobleappkotlin.R
import pl.udu.uwr.pum.verynobleappkotlin.adapters.nobelprizes.NobelPrizeAdapter
import pl.udu.uwr.pum.verynobleappkotlin.adapters.nobelprizes.NobelPrizeComparator
import pl.udu.uwr.pum.verynobleappkotlin.databinding.FragmentNobelAwardsBinding
import pl.udu.uwr.pum.verynobleappkotlin.util.Resource
import pl.udu.uwr.pum.verynobleappkotlin.util.categories

class NobelAwardsFragment : Fragment() {

    private lateinit var binding: FragmentNobelAwardsBinding

    private val nobelPrizesViewModel: NobelPrizesViewModel by viewModels()
    private val TAG = "NobelAwardsFragment"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNobelAwardsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupSpinner()

        val nobelAdapter = NobelPrizeAdapter(NobelPrizeComparator())
        setupRecyclerView(nobelAdapter)

        observeNoblePrizeList(nobelAdapter)
    }

    private fun observeNoblePrizeList(nobelAdapter: NobelPrizeAdapter) {
        nobelPrizesViewModel.noblePrizes.observe(viewLifecycleOwner) { response ->
            when (response) {
                is Resource.Success -> {
                    hideProgressBar()
                    response.data?.let { nobelAdapter.submitList(it.nobelPrizes) }
                }
                is Resource.Error -> {
                    hideProgressBar()
                    response.message?.let { Log.e(TAG, "Error occurred: $it") }
                }
                is Resource.Loading -> showProgressBar()
            }
        }
    }

    private fun setupRecyclerView(nobelAdapter: NobelPrizeAdapter) {
        binding.nobelPrizeRV.apply {
            adapter = nobelAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }

    private fun setupSpinner() {
        binding.categorySpinner.apply {
            adapter = ArrayAdapter(
                context,
                R.layout.spinner_nobel_award_layout,
                categories.keys.map { it })
            onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    nobelPrizesViewModel.getNobelPrizes(categories.values.map { it }[position])
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {}
            }
        }
    }

    private fun hideProgressBar(){
        binding.nobelPrizeProgressBar.visibility = View.INVISIBLE
    }

    private fun showProgressBar(){
        binding.nobelPrizeProgressBar.visibility = View.VISIBLE
    }
}