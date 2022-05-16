package pl.edu.uwr.pum.parcelableexamplekotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

const val EXTRA_KEY = "parcel_example"
const val EXTRA_SERIALIZABLE = "serializable_example"
const val EXTRA_PARCELIZE = "parcelize_example"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.sendButton).setOnClickListener(){
            val intent = Intent(this, SecondActivity::class.java)
                .putExtra(EXTRA_KEY, Properties(1, 2, "String"))
                .putExtra(EXTRA_SERIALIZABLE, SerializableProperties(11, 11, "Serializable"))
                .putExtra(EXTRA_PARCELIZE, ParcelizeProperties(0, 0, "Parcelize"))
            startActivity(intent)
        }
    }
}