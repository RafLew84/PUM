package pl.udu.uwr.pum.polishnewsapp.ui.features.latest

import android.opengl.Visibility
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import pl.udu.uwr.pum.polishnewsapp.R
import pl.udu.uwr.pum.polishnewsapp.data.db.entities.NewsArticle
import pl.udu.uwr.pum.polishnewsapp.databinding.FragmentLatestNewsBinding
import pl.udu.uwr.pum.polishnewsapp.shared.ArticleAdapter
import pl.udu.uwr.pum.polishnewsapp.util.Resource


@AndroidEntryPoint
class LatestNewsFragment : Fragment() {

    private val viewModel: LatestNewsViewModel by viewModels()

    lateinit var binding: FragmentLatestNewsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLatestNewsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val articleAdapter = ArticleAdapter()
        binding.apply {
            latestRecyclerView.apply {
                adapter = articleAdapter
                layoutManager = LinearLayoutManager(requireContext())
            }

            viewLifecycleOwner.lifecycleScope.launchWhenStarted {
                viewModel.latestNews.collect{
                    val result = it ?: return@collect
                    layoutState(result)
                    articleAdapter.submitList(result.data)
                }
            }
        }
    }

    private fun FragmentLatestNewsBinding.layoutState(result: Resource<List<NewsArticle>>) {
        swipeToRefreshLayout.isRefreshing = result is Resource.Loading
        latestRecyclerView.isVisible = !result.data.isNullOrEmpty()
        errorMessageTextView.isVisible = result.throwable != null && result.data.isNullOrEmpty()
        retryButton.isVisible = result.throwable != null && result.data.isNullOrEmpty()
        errorMessageTextView.text =
            getString(R.string.blad, result.throwable?.localizedMessage ?: R.string.nieznany_blad)
    }
}