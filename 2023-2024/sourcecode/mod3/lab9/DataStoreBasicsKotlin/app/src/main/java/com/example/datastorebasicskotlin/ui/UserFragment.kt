package com.example.datastorebasicskotlin.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.datastorebasicskotlin.R
import com.example.datastorebasicskotlin.data.dummydata.DataProvider
import com.example.datastorebasicskotlin.databinding.FragmentUserBinding
import com.example.datastorebasicskotlin.viewmodel.UserViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class UserFragment : Fragment() {

     private lateinit var binding: FragmentUserBinding

    private val viewModel: UserViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentUserBinding.inflate(inflater)

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.username.collectLatest { user ->
                binding.textView.text = "Current saved user: $user"
            }
        }

        binding.addButton.setOnClickListener { viewModel.addUsername(DataProvider.username) }
        binding.clearButton.setOnClickListener { viewModel.clearUsername() }

        return binding.root
    }
}