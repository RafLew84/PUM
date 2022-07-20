package pl.edu.uwr.pum.pumapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import pl.edu.uwr.pum.pumapp.R

class StartFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val activity: AppCompatActivity = activity as AppCompatActivity
        activity.supportActionBar?.title = getString(R.string.app_name)
        return inflater.inflate(R.layout.fragment_start, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<LinearLayout>(R.id.start_button_layout).setOnClickListener {
            findNavController().navigate(StartFragmentDirections.actionStartFragmentToModuleListFragment())
        }
    }
}