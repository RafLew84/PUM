package pl.udu.uwr.pum.verynobleappjava.ui.fragments.wiki;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebViewClient;

import pl.udu.uwr.pum.verynobleappjava.R;
import pl.udu.uwr.pum.verynobleappjava.databinding.FragmentLaureateBinding;
import pl.udu.uwr.pum.verynobleappjava.databinding.FragmentWikiLaureateFragmentBinding;

public class WikiLaureateFragmentFragment extends Fragment {

    private FragmentWikiLaureateFragmentBinding binding;

    private String wikiUrl;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentWikiLaureateFragmentBinding.inflate(inflater, container, false);
        wikiUrl = requireArguments().getString("url");
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.webView.setWebViewClient(new WebViewClient());
        binding.webView.loadUrl(wikiUrl);
    }
}