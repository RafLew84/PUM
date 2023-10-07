package com.example.resourcepatternbasicskotlin.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.resourcepatternbasicskotlin.R
import com.example.resourcepatternbasicskotlin.databinding.FragmentCommentsBinding
import com.example.resourcepatternbasicskotlin.util.Resource
import com.example.resourcepatternbasicskotlin.viewmodel.CommentsViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class CommentsFragment : Fragment() {

    private lateinit var binding: FragmentCommentsBinding

    private val viewModel: CommentsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCommentsBinding.inflate(inflater)

        val commentAdapter = CommentAdapter(CommentComparator())
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.comments.collectLatest { response ->
                when (response) {
                    is Resource.Success -> {
                        response.data?.let { res ->
                            commentAdapter.submitList(res)
                        }
                    }

                    is Resource.Error -> {}
                    is Resource.Loading -> {}
                }
            }
        }

        binding.recycler.apply{
            adapter = commentAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }

        return binding.root
    }
}