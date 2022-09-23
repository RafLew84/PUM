package pl.udu.uwr.pum.verynobleappkotlin.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import pl.udu.uwr.pum.verynobleappkotlin.R
import pl.udu.uwr.pum.verynobleappkotlin.ui.NobelViewModel

class NobelAwardsFragment : Fragment() {

    private val nobelViewModel: NobelViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_nobel_awards, container, false)
    }
}