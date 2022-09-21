package pl.udu.uwr.pum.verynobleappkotlin.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import pl.udu.uwr.pum.verynobleappkotlin.R
import pl.udu.uwr.pum.verynobleappkotlin.api.RetrofitInstance
import pl.udu.uwr.pum.verynobleappkotlin.data.NobelPrizeResponse
import retrofit2.*

class NobelAwardsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_nobel_awards, container, false)
    }
}