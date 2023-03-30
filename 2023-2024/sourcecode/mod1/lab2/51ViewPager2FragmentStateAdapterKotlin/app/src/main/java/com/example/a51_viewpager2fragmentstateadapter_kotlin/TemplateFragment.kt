package com.example.a51_viewpager2fragmentstateadapter_kotlin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.a51_viewpager2fragmentstateadapter_kotlin.databinding.FragmentTemplateBinding

class TemplateFragment(private val position: Int) : Fragment() {

    private lateinit var binding: FragmentTemplateBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTemplateBinding.inflate(inflater)
        binding.textView.text = "Fragment ${position + 1}"
        return binding.root
    }
}