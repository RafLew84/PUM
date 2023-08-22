package com.example.stateflowbasicskotlin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.stateflowbasicskotlin.databinding.FragmentCounterBinding
import com.example.stateflowbasicskotlin.viewmodel.CounterViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class CounterFragment : Fragment() {

    private lateinit var binding: FragmentCounterBinding

    private val viewModel: CounterViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCounterBinding.inflate(inflater)

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.stateFlow.collectLatest{ counter ->
                    binding.counterText.text = counter.toString()
                }
            }
        }

        binding.increaseButton.setOnClickListener {
            viewModel.increase()
        }

        return binding.root
    }
}