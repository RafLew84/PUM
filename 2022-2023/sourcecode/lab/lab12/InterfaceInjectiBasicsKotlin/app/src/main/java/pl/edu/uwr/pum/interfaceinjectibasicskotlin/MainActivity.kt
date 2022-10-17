package pl.edu.uwr.pum.interfaceinjectibasicskotlin

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import pl.edu.uwr.pum.interfaceinjectibasicskotlin.computer.Computer
import pl.edu.uwr.pum.interfaceinjectibasicskotlin.di.DaggerComputerComponent
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var computer: Computer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val component = DaggerComputerComponent.create()
        component.inject(this)

        val textView = findViewById<TextView>(R.id.textview)
        textView.text = computer.cpuName()
    }
}