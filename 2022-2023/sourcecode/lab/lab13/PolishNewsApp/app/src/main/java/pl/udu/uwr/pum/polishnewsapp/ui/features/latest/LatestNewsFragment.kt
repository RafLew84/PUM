package pl.udu.uwr.pum.polishnewsapp.ui.features.latest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import pl.udu.uwr.pum.polishnewsapp.databinding.FragmentLatestNewsBinding
import pl.udu.uwr.pum.polishnewsapp.shared.ArticleAdapter


@AndroidEntryPoint
class LatestNewsFragment : Fragment() {

    //private val viewModel: LatestNewsViewModel by viewModels()

    lateinit var binding: FragmentLatestNewsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLatestNewsBinding.inflate(layoutInflater, container, false)
        //viewModel.getLatestNews()
        return binding.root
    }

//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//        val articleAdapter = ArticleAdapter()
//        viewModel.latestNews.observe(viewLifecycleOwner){
//            println(it.size)
//            articleAdapter.submitList(it)
//        }
//        binding.latestRecyclerView.apply {
//                adapter = articleAdapter
//                layoutManager = LinearLayoutManager(requireContext())
//            }
//    }
}