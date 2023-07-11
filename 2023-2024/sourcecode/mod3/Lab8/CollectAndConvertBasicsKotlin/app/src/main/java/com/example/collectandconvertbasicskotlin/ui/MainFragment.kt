package com.example.collectandconvertbasicskotlin.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.collectandconvertbasicskotlin.R
import com.example.collectandconvertbasicskotlin.databinding.FragmentMainBinding


class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater)

        binding.navButton.setOnClickListener {
            val action = MainFragmentDirections.actionMainFragmentToSecondFragment()
            Navigation.findNavController(requireView()).navigate(action)
        }

        return binding.root
    }
}