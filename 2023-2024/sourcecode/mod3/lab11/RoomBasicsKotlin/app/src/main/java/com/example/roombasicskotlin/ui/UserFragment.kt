package com.example.roombasicskotlin.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.roombasicskotlin.data.dummydata.DataProvider
import com.example.roombasicskotlin.databinding.FragmentUserBinding
import com.example.roombasicskotlin.viewmodel.UserViewModel
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

        val userAdapter = UserAdapter(UserComparator())
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.usersState.collectLatest { users ->
                userAdapter.submitList(users)
            }
        }

        binding.rvList.apply{
            adapter = userAdapter
            layoutManager = LinearLayoutManager(requireContext())
            itemAnimator = null
        }

        binding.addButton.setOnClickListener { viewModel.addUser(DataProvider.user) }
        binding.clearButton.setOnClickListener { viewModel.clearUsers() }

        return binding.root
    }
}