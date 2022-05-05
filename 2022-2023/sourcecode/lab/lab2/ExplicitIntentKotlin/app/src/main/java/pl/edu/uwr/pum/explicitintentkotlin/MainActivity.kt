package pl.edu.uwr.pum.explicitintentkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText

const val EXTRA_MESSAGE = "pl.edu.uwr.pum.explicitintentkotlin.MESSAGE"

class MainActivity : AppCompatActivity() {

    private val editText: EditText by lazy{findViewById(R.id.editTextMain)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun startSecondActivity(view: View) {
        val message = editText.text.toString()
        val intent = Intent(this, SecondActivity::class.java).apply {
            putExtra(EXTRA_MESSAGE, message)
        }
        startActivity(intent)
    }
}