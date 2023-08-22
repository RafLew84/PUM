package com.example.sharedflowbasicskotlin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.sharedflowbasicskotlin.databinding.FragmentNumberBinding
import com.example.sharedflowbasicskotlin.viewmodel.NumberViewModel
import kotlinx.coroutines.launch

class NumberFragment : Fragment() {

    private lateinit var binding: FragmentNumberBinding

    private val viewModel: NumberViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNumberBinding.inflate(inflater)

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.sharedFlow.collect{ number ->
                    binding.numberText.text = number.toString()
                }
            }
        }

        return binding.root
    }
}