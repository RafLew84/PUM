package pl.edu.uwr.pum.counterappkotlin

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class MainActivity : AppCompatActivity() {

    private var count = 0
    private val showCount: TextView by lazy{findViewById(R.id.show_count)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showCount.text = String.format(Locale.GERMAN, "%,d", count)
    }

    fun countUpButton(view: View?) {
        count++
        showCount.text = count.toString()
    }
}