package com.example.viewmodelbasics_kotlin.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.viewmodelbasics_kotlin.R
import com.example.viewmodelbasics_kotlin.databinding.FragmentListBinding
import com.example.viewmodelbasics_kotlin.viewmodel.WordViewModel

class ListFragment : Fragment() {

    private lateinit var binding: FragmentListBinding

    private val viewModel: WordViewModel by viewModels()
    private val wordAdapter by lazy { WordAdapter(WordComparator())}

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListBinding.inflate(inflater)

        wordAdapter.submitList(viewModel.wordList)

        binding.rvList.apply{
            adapter = wordAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }

        binding.addButton.setOnClickListener { onAddWord() }
        binding.resetButton.setOnClickListener { onResetWords() }
        binding.clearButton.setOnClickListener { onClearWords() }

        return binding.root
    }

    private fun onAddWord() {
        val word = binding.wordEditText.text.toString()
        viewModel.addWord(word)
        wordAdapter.notifyDataSetChanged()
    }

    private fun onResetWords(){
        viewModel.reinitialize()
        wordAdapter.notifyDataSetChanged()
    }

    private fun onClearWords(){
        viewModel.clear()
        wordAdapter.notifyDataSetChanged()
    }
}