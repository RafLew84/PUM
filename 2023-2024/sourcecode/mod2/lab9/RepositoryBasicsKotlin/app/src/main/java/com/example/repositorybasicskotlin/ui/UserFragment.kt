package com.example.repositorybasicskotlin.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.repositorybasicskotlin.R
import com.example.repositorybasicskotlin.databinding.FragmentUserBinding
import com.example.repositorybasicskotlin.viewmodel.UserViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class UserFragment : Fragment() {

    private lateinit var binding: FragmentUserBinding

    private val viewModel: UserViewModel by viewModels()
    private val userAdapter by lazy { UserAdapter(UserComparator())}

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentUserBinding.inflate(inflater)

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.usersList.collectLatest{ users ->
                    userAdapter.submitList(users)
                }
            }
        }

        binding.rvList.apply{
            adapter = userAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }

        return binding.root
    }
}