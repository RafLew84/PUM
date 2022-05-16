package pl.edu.uwr.pum.parcelableexamplekotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

const val EXTRA_KEY = "parcel_example"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.sendButton).setOnClickListener(){
            val intent = Intent(this, SecondActivity::class.java)
                .putExtra(EXTRA_KEY, Properties(1, 2, "String"))
            startActivity(intent)
        }
    }
}