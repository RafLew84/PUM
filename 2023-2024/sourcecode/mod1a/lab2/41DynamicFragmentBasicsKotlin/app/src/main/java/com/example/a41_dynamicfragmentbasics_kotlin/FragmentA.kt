package com.example.a41_dynamicfragmentbasics_kotlin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.a41_dynamicfragmentbasics_kotlin.databinding.FragmentABinding

class FragmentA : Fragment() {

    private lateinit var binding: FragmentABinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentABinding.inflate(inflater)
        binding.startFragmentB.setOnClickListener {
            requireActivity().supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragment_container_view_tag, FragmentB())
                .addToBackStack(null)
                .commit()
        }
        return binding.root
    }
}