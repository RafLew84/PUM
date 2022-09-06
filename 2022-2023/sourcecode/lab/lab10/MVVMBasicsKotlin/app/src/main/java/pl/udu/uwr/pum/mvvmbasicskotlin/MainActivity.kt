package pl.udu.uwr.pum.mvvmbasicskotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.viewModels

class MainActivity : AppCompatActivity() {

    private val textView: TextView by lazy { findViewById(R.id.textView) }
    private val button: Button by lazy { findViewById(R.id.button) }

    private val myViewModel: MyViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myViewModel.myData.observe(this){
            textView.text = it
        }

        //button.setOnClickListener { myViewModel._myData.value = "zmiana" }
    }
}