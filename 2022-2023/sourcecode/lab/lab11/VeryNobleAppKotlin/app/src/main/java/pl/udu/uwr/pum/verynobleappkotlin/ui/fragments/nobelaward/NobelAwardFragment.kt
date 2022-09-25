package pl.udu.uwr.pum.verynobleappkotlin.ui.fragments.nobelaward

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import pl.udu.uwr.pum.verynobleappkotlin.adapters.nobleprizelaureates.LaureateAdapter
import pl.udu.uwr.pum.verynobleappkotlin.adapters.nobleprizelaureates.LaureateComparator
import pl.udu.uwr.pum.verynobleappkotlin.databinding.FragmentNobelAwardBinding
import pl.udu.uwr.pum.verynobleappkotlin.util.Cat
import pl.udu.uwr.pum.verynobleappkotlin.util.Resource
import pl.udu.uwr.pum.verynobleappkotlin.util.categories

class NobelAwardFragment : Fragment() {

    private lateinit var binding: FragmentNobelAwardBinding

    private val nobelPrizeViewModel: NobelPrizeViewModel by viewModels()
    private val TAG = "NobelAwardFragment"

    private val category: String? by lazy { requireArguments().getString("category") }
    private val awardYear: String? by lazy { requireArguments().getString("awardYear") }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNobelAwardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        nobelPrizeViewModel.getNobelPrize(year= awardYear?.toInt()!!, category= categories[Cat.valueOf(category!!.uppercase().filterNot { it.isWhitespace() })]!!)

        val laureateAdapter = LaureateAdapter(LaureateComparator())
        setupRecyclerView(laureateAdapter)

        observeNoblePrize(laureateAdapter)
    }

    private fun hideProgressBar(){
        binding.nobelPrizeProgressBar.visibility = View.INVISIBLE
    }

    private fun showProgressBar(){
        binding.nobelPrizeProgressBar.visibility = View.VISIBLE
    }

    private fun observeNoblePrize(laureateAdapter: LaureateAdapter) {
        nobelPrizeViewModel.noblePrize.observe(viewLifecycleOwner) { response ->
            when (response) {
                is Resource.Success -> {
                    hideProgressBar()
                    response.data?.let {
                        binding.categoryFullNameTextView.text = it.nobelPrizes.first().categoryFullName.en
                        binding.dateAwardTextView.text = it.nobelPrizes.first().dateAwarded
                        laureateAdapter.submitList(it.nobelPrizes.first().laureates)
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

    private fun setupRecyclerView(laureateAdapter: LaureateAdapter) {
        binding.nobelAwardRV.apply {
            adapter = laureateAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }
}