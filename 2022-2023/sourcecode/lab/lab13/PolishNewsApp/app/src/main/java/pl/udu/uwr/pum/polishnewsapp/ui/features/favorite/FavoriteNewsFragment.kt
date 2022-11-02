package pl.udu.uwr.pum.polishnewsapp.ui.features.favorite

import android.content.Intent
import android.net.Uri
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
import pl.udu.uwr.pum.polishnewsapp.databinding.FragmentFavoriteNewsBinding
import pl.udu.uwr.pum.polishnewsapp.shared.ArticleAdapter

@AndroidEntryPoint
class FavoriteNewsFragment : Fragment() {

    lateinit var binding: FragmentFavoriteNewsBinding

    private val viewModel: FavoriteViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFavoriteNewsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val articleAdapter = ArticleAdapter(
            onItemClick = {
                val uri = Uri.parse(it.url)
                val intent = Intent(Intent.ACTION_VIEW, uri)
                requireActivity().startActivity(intent)
            },
            onFavoriteClick = { viewModel.addFavorite(it) }
        )

        binding.apply {
            favoriteRecyclerView.apply {
                adapter = articleAdapter
                layoutManager = LinearLayoutManager(requireContext())
            }

            viewLifecycleOwner.lifecycleScope.launchWhenStarted {
                viewModel.favorites.collect{
                    val favorites = it ?: return@collect
                    articleAdapter.submitList(favorites)
                    messageTextView.isVisible = favorites.isEmpty()
                    favoriteRecyclerView.isVisible = favorites.isNotEmpty()
                }
            }
        }
    }
}