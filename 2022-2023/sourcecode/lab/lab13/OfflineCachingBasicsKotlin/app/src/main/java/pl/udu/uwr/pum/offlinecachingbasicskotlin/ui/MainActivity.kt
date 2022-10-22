package pl.udu.uwr.pum.offlinecachingbasicskotlin.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import pl.udu.uwr.pum.offlinecachingbasicskotlin.R
import pl.udu.uwr.pum.offlinecachingbasicskotlin.data.adapters.UserAdapter
import pl.udu.uwr.pum.offlinecachingbasicskotlin.data.adapters.UserComparator
import pl.udu.uwr.pum.offlinecachingbasicskotlin.databinding.ActivityMainBinding
import pl.udu.uwr.pum.offlinecachingbasicskotlin.util.Resource

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val viewModel: UserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val adapter = UserAdapter(UserComparator())
        setupRecyclerView(adapter)

        viewModel.users.observe(this) { result ->
            adapter.submitList(result.data)

            binding.progressBar.isVisible = result is Resource.Loading && result.data.isNullOrEmpty()
        }

    }

    private fun setupRecyclerView(userAdapter: UserAdapter) {
        binding.recyclerView.apply {
            adapter = userAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }
    }
}