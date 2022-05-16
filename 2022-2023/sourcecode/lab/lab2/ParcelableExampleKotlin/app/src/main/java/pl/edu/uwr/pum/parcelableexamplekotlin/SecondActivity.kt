package pl.edu.uwr.pum.parcelableexamplekotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val prop = intent.getParcelableExtra<Properties>(EXTRA_KEY)
        if (prop != null)
            ((prop.a + prop.b).toString() + " " + prop.c)
                .also { findViewById<TextView>(R.id.textView).text = it }
    }
}