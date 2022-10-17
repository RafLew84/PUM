package pl.edu.uwr.pum.valueinjectbasicskotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import pl.edu.uwr.pum.valueinjectbasicskotlin.computer.Computer
import pl.edu.uwr.pum.valueinjectbasicskotlin.di.DaggerComputerComponent
import pl.edu.uwr.pum.valueinjectbasicskotlin.di.modules.GpuModule
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var computer: Computer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val component = DaggerComputerComponent.builder()
            .gpuModule(GpuModule(8))
            .build()

        component.inject(this)
        val textView = findViewById<TextView>(R.id.textview)
        textView.text = computer.getGpuCores()
    }
}