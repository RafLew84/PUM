package com.example.mvvmbasicskotlin.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvmbasicskotlin.databinding.FragmentUsersBinding
import com.example.mvvmbasicskotlin.model.User
import com.example.mvvmbasicskotlin.viewmodel.UserViewModel

class UsersFragment : Fragment() {

    private lateinit var binding: FragmentUsersBinding

    private val viewModel: UserViewModel by viewModels()
    private val userAdapter by lazy { UserAdapter(UserComparator())}

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentUsersBinding.inflate(inflater)


        viewModel.usersList.observe(viewLifecycleOwner) { users ->
            userAdapter.submitList(users.toMutableList())
        }

        binding.rvList.apply{
            adapter = userAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }

        binding.addButton.setOnClickListener { onAddUser() }
        binding.resetButton.setOnClickListener { onResetUsers() }
        binding.clearButton.setOnClickListener { onClearUsers() }

        return binding.root
    }

    private fun onAddUser() {
        val firstName = binding.firstNameEditText.text.toString().trim()
        val lastName = binding.lastNameEditText.text.toString().trim()

        if (firstName.isNotBlank() && lastName.isNotBlank()) {
            val newUser = User(firstName, lastName)
            viewModel.addUser(newUser)

            binding.firstNameEditText.text?.clear()
            binding.lastNameEditText.text?.clear()
        }
    }

    private fun onResetUsers() {
        viewModel.reinitialize()
    }

    private fun onClearUsers() {
        viewModel.clear()
    }
}