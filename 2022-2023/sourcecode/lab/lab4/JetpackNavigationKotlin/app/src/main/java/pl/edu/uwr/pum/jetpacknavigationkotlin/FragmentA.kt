package pl.edu.uwr.pum.jetpacknavigationkotlin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.google.android.material.floatingactionbutton.FloatingActionButton

class FragmentA : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_a, container, false)

        view.findViewById<FloatingActionButton>(R.id.fabA).setOnClickListener {
            //val action = FragmentADirections.toFragmentB()

            val args = Bundle()
            args.putInt("key", 5)
            Navigation.findNavController(view).navigate(R.id.to_fragmentB, args)
        }

        return view
    }
}