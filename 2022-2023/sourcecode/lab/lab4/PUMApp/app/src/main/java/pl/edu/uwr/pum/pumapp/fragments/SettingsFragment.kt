package pl.edu.uwr.pum.pumapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import pl.edu.uwr.pum.pumapp.R

class SettingsFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val activity: AppCompatActivity = activity as AppCompatActivity
        activity.supportActionBar?.title = getString(R.string.settings)
        return inflater.inflate(R.layout.fragment_settings, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val textView: TextView = view.findViewById(R.id.textViewTheme)
        view.findViewById<RadioGroup>(R.id.radioButtonTheme).setOnCheckedChangeListener { _, checkedId ->
            when(checkedId){
                R.id.radioButtonLight -> {
                    textView.text = getString(R.string.motywJ)
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                }
                R.id.radioButtonDark -> {
                    textView.text = getString(R.string.motywD)
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                }
            }
        }
    }
}