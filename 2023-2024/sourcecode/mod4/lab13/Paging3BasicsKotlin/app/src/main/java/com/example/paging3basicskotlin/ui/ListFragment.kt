package com.example.paging3basicskotlin.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.paging3basicskotlin.databinding.FragmentListBinding
import com.example.paging3basicskotlin.viewmodel.SwapiViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class ListFragment : Fragment() {

    private lateinit var binding: FragmentListBinding

    private val viewModel: SwapiViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListBinding.inflate(inflater)

        val characterAdapter = CharacterAdapter(CharacterComparator())

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.getData().collectLatest { pagingData ->
                characterAdapter.submitData(pagingData)

            }
        }

        binding.recycler.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = characterAdapter
            setHasFixedSize(true)
        }


        return binding.root
    }
}