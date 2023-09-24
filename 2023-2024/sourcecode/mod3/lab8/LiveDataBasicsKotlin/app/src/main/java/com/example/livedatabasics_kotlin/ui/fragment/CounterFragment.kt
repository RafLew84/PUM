package com.example.livedatabasics_kotlin.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.livedatabasics_kotlin.databinding.FragmentCounterBinding
import com.example.livedatabasics_kotlin.viewmodel.CounterViewModel

class CounterFragment : Fragment() {

    private lateinit var binding: FragmentCounterBinding

    private val viewModel: CounterViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCounterBinding.inflate(inflater)

        viewModel.counter.observe(viewLifecycleOwner) { newValue ->
            binding.showCount.text = newValue.toString()
        }

        binding.increaseButton.setOnClickListener { viewModel.increase() }
        binding.decreaseButton.setOnClickListener { viewModel.decrease() }
        binding.resetButtton.setOnClickListener { viewModel.clear() }

        return binding.root
    }
}