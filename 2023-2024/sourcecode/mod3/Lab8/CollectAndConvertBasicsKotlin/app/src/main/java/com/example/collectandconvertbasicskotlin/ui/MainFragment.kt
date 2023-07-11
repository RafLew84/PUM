package com.example.collectandconvertbasicskotlin.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.collectandconvertbasicskotlin.R
import com.example.collectandconvertbasicskotlin.databinding.FragmentMainBinding
import com.example.collectandconvertbasicskotlin.viewmodel.CounterViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch


class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding

    private val viewModel: CounterViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater)

        binding.navButton.setOnClickListener {
            val action = MainFragmentDirections.actionMainFragmentToSecondFragment()
            Navigation.findNavController(requireView()).navigate(action)
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.counter.collectLatest{ counter ->
                    binding.counterText.text = counter.toString()
                }
            }
        }

        return binding.root
    }
}