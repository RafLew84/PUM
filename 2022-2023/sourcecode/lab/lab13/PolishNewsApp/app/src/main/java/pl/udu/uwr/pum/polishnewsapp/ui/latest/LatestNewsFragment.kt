package pl.udu.uwr.pum.polishnewsapp.ui.latest

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import pl.udu.uwr.pum.polishnewsapp.R


@AndroidEntryPoint
class LatestNewsFragment : Fragment() {

    private val viewModel: LatestNewsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_latest_news, container, false)
    }
}