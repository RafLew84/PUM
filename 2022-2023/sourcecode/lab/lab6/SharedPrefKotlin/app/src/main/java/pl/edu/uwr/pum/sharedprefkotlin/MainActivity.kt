package pl.edu.uwr.pum.sharedprefkotlin

import android.content.SharedPreferences
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.preference.PreferenceManager
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import pl.edu.uwr.pum.sharedprefkotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val view = binding.root
        setContentView(view)

        var counter = 0

        binding.countUpButton.setOnClickListener {
            counter++
            binding.counter1TextView.text = counter.toString()
        }

        binding.countDownButton.setOnClickListener {
            counter--
            binding.counter1TextView.text = counter.toString()
        }
    }

    override fun onResume() {
        super.onResume()
        val sharedPref = getSharedPreferences("fileName", MODE_PRIVATE)
        binding.counter1TextView.text = sharedPref.getInt("counter", 0).toString()
    }

    override fun onPause() {
        super.onPause()
        val sharedPref = getSharedPreferences("fileName", MODE_PRIVATE)
        val edit = sharedPref.edit()
        edit.apply {
            putInt("counter", binding.counter1TextView.text.toString().toInt())
            apply()
        }
    }
}