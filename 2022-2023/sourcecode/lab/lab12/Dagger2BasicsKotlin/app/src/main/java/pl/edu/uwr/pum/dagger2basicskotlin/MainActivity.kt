package pl.edu.uwr.pum.dagger2basicskotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import pl.edu.uwr.pum.dagger2basicskotlin.computer.Computer
import pl.edu.uwr.pum.dagger2basicskotlin.di.DaggerComputerComponent

class MainActivity : AppCompatActivity() {

    private lateinit var computer: Computer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val component = DaggerComputerComponent.create()
        computer = component.getComputer()
        val textView = findViewById<TextView>(R.id.textview)
        textView.text = computer.work()
    }
}