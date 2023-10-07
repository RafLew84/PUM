package com.example.a31_tablayoutviewpager2navigationbasics_kotlin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.a31_tablayoutviewpager2navigationbasics_kotlin.databinding.FragmentTemplateBinding

class TemplateFragment : Fragment() {

    private lateinit var binding: FragmentTemplateBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTemplateBinding.inflate(inflater)

        arguments?.takeIf { it.containsKey(arg) }?.apply {
            binding.textView.text = "Fragment ${getInt(arg)}"
        }

        return binding.root
    }
}