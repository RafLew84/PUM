package pl.edu.uwr.pum.explicitintentkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView

const val EXTRA_REPLY = "pl.edu.uwr.pum.explicitintentkotlin.REPLY"

class SecondActivity : AppCompatActivity() {

    private val editText: EditText by lazy { findViewById(R.id.editTextSecond) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val message = intent.getStringExtra(EXTRA_MESSAGE)
        findViewById<TextView>(R.id.textView).apply {
            text = message
        }
    }

    fun returnMessage(view: View) {
        setResult(
            RESULT_OK,
            Intent().apply {
                putExtra(EXTRA_REPLY,
                    findViewById<EditText>(R.id.editTextSecond).text.toString())
            })
        finish()
    }
}