package pl.udu.uwr.pum.verynobleappkotlin.ui.fragments.wiki

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import pl.udu.uwr.pum.verynobleappkotlin.databinding.FragmentWikiLaureateBinding


class WikiLaureateFragment : Fragment() {

    private lateinit var binding: FragmentWikiLaureateBinding

    private val wikiUrl: String? by lazy { requireArguments().getString("url") }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWikiLaureateBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.webView.apply {
            webViewClient = WebViewClient()
            loadUrl(wikiUrl!!)
        }
    }
}