package com.example.retrofitbasicskotlin.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofitbasicskotlin.R
import com.example.retrofitbasicskotlin.databinding.FragmentPostBinding
import com.example.retrofitbasicskotlin.viewmodel.PostViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class PostFragment : Fragment() {

    private lateinit var binding: FragmentPostBinding

    private val viewModel: PostViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPostBinding.inflate(inflater)

        val userAdapter = PostAdapter(PostComparator())
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.posts.collectLatest { posts ->
                userAdapter.submitList(posts)
            }
        }

        binding.recycler.apply{
            adapter = userAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }

        return binding.root
    }
}