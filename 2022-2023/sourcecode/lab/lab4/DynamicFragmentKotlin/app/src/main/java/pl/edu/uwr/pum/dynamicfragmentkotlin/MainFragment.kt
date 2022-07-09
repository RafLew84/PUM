package pl.edu.uwr.pum.dynamicfragmentkotlin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class MainFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_main, container, false)
        view.findViewById<Button>(R.id.start_fragment_a)
            .setOnClickListener { requireActivity().supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragment_container_view_tag, FragmentA())
                .addToBackStack(null)
                .commit()
            }
        return view
    }
}