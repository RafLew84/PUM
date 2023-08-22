package com.example.sharedpreferencesbasicskotlin.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.sharedpreferencesbasicskotlin.data.dummydata.DataProvider
import com.example.sharedpreferencesbasicskotlin.databinding.FragmentUserBinding
import com.example.sharedpreferencesbasicskotlin.viewmodel.UserViewModel
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