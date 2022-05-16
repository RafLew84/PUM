package pl.edu.uwr.pum.parcelableexamplekotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val prop = intent.getParcelableExtra<Properties>(EXTRA_KEY)
        val serProp = intent.getSerializableExtra(EXTRA_SERIALIZABLE) as SerializableProperties
        val parProp = intent.getParcelableExtra<ParcelizeProperties>(EXTRA_PARCELIZE)

        if (prop != null && parProp != null)
            ((prop.a + prop.b).toString() + " " + prop.c + "----" +
                    serProp.a + serProp.b + " " + serProp.c + "----\n" +
                    ( parProp.a + parProp.b).toString() + " " + parProp.c)
                .also { findViewById<TextView>(R.id.textView).text = it }
    }
}