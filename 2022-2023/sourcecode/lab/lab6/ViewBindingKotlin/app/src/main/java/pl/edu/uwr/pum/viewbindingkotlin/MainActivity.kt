package pl.edu.uwr.pum.viewbindingkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import pl.edu.uwr.pum.viewbindingkotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val view = binding.root
        setContentView(view)

        binding.textview.text = "HELLO"
        binding.button.setOnClickListener {
            binding.textview.text = "Click!!!"
        }
    }
}