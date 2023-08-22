package com.example.a11_jetpacknavigationbasics_kotlin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.a11_jetpacknavigationbasics_kotlin.databinding.FragmentABinding

class FragmentA : Fragment() {

    private lateinit var binding: FragmentABinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentABinding.inflate(inflater)

        binding.fabA.setOnClickListener {
            val action = FragmentADirections.actionFragmentAToFragmentB(5)
            Navigation.findNavController(requireView()).navigate(action)

//            val args = Bundle()
//            args.putInt("key", 5)
//            Navigation.findNavController(requireView()).navigate(R.id.fragmentB, args)
        }

        return binding.root
    }
}