package pl.edu.uwr.pum.jetpacknavigationkotlin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.Navigation
import com.google.android.material.floatingactionbutton.FloatingActionButton

class FragmentB : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_b, container, false)

        view.findViewById<TextView>(R.id.textViewB).text = arguments?.getInt("key").toString()

        view.findViewById<FloatingActionButton>(R.id.fabB).setOnClickListener {
            val action = FragmentBDirections.toFragmentA()
            Navigation.findNavController(view).navigate(action)
        }

        return view
    }
}