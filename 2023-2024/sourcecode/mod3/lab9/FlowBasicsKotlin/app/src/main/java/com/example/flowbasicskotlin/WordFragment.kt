package com.example.flowbasicskotlin

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.flowbasicskotlin.databinding.FragmentWordBinding
import com.example.flowbasicskotlin.viewmodel.WordViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch


class WordFragment : Fragment() {

    private lateinit var binding: FragmentWordBinding
    private val viewModel: WordViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWordBinding.inflate(inflater)

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.wordsFlow.collect{ word ->
                    binding.wordText.text = word
                }
            }
        }

        return binding.root
    }
}