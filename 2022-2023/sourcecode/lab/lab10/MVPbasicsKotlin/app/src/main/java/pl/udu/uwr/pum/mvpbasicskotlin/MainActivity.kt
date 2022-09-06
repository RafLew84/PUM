package pl.udu.uwr.pum.mvpbasicskotlin

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), MyView {

    private val textView: TextView by lazy { findViewById(R.id.textView) }
    private val button: Button by lazy { findViewById(R.id.button) }

    private val presenter: Presenter by lazy { Presenter(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener { presenter.getDetails() }
    }

    override fun onDisplay(text: String) {
        textView.text = text
    }
}