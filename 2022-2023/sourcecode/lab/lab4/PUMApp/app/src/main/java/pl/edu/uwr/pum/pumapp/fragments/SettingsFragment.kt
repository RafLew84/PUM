package pl.edu.uwr.pum.pumapp.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import pl.edu.uwr.pum.pumapp.R
import java.util.*

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

        val themeTextView: TextView = view.findViewById(R.id.textViewCurrentTheme)
        view.findViewById<RadioGroup>(R.id.radioButtonTheme).setOnCheckedChangeListener { _, checkedId ->
            when(checkedId){
                R.id.radioButtonLight -> {
                    themeTextView.text = getString(R.string.light_theme)
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                }
                R.id.radioButtonDark -> {
                    themeTextView.text = getString(R.string.dark_theme)
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                }
                R.id.radioButtonDefault -> {
                    themeTextView.text = getString(R.string.current_theme)
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
                }
            }
        }
    }
}