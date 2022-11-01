package pl.udu.uwr.pum.polishnewsapp.ui.features.latest

import android.os.Bundle
import android.view.*
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import pl.udu.uwr.pum.polishnewsapp.R
import pl.udu.uwr.pum.polishnewsapp.data.db.entities.NewsArticle
import pl.udu.uwr.pum.polishnewsapp.databinding.FragmentLatestNewsBinding
import pl.udu.uwr.pum.polishnewsapp.shared.ArticleAdapter
import pl.udu.uwr.pum.polishnewsapp.util.Resource
import pl.udu.uwr.pum.polishnewsapp.util.exhaustive
import pl.udu.uwr.pum.polishnewsapp.util.showSnackbar


@AndroidEntryPoint
class LatestNewsFragment : Fragment() {

    private val viewModel: LatestNewsViewModel by viewModels()

    private val menuHost: MenuHost by lazy { requireActivity() }

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
                    articleAdapter.submitList(result.data){
                        if (viewModel.pendingScrollToTop) {
                            latestRecyclerView.scrollToPosition(0)
                            viewModel.pendingScrollToTop = false
                        }
                    }
                }
            }

            swipeToRefreshLayout.setOnRefreshListener { viewModel.refreshOnDemand() }
            retryButton.setOnClickListener { viewModel.refreshOnDemand() }
            viewLifecycleOwner.lifecycleScope.launchWhenStarted {
                viewModel.events.collect{event ->
                    when(event){
                        is LatestNewsViewModel.Event.ShowErrorMessage ->
                            showSnackbar(getString(R.string.blad, event.t.localizedMessage?: R.string.nieznany_blad))
                    }.exhaustive
                }
            }
        }

        handleMenu()
    }

    private fun handleMenu() {
        menuHost.addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.menu_latest, menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return when (menuItem.itemId) {
                    R.id.refresh -> {
                        viewModel.refreshOnDemand()
                        true
                    }
                    else -> false
                }
            }
        }, viewLifecycleOwner, Lifecycle.State.RESUMED)
    }

    private fun FragmentLatestNewsBinding.layoutState(result: Resource<List<NewsArticle>>) {
        swipeToRefreshLayout.isRefreshing = result is Resource.Loading
        latestRecyclerView.isVisible = !result.data.isNullOrEmpty()
        errorMessageTextView.isVisible = result.throwable != null && result.data.isNullOrEmpty()
        retryButton.isVisible = result.throwable != null && result.data.isNullOrEmpty()
        errorMessageTextView.text =
            getString(R.string.blad, result.throwable?.localizedMessage ?: R.string.nieznany_blad)
    }

    override fun onStart() {
        super.onStart()
        viewModel.refreshOnStart()
    }
}