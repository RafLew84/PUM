package pl.edu.uwr.pum.dagger_hilt_room_basicskotlin.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint
import pl.edu.uwr.pum.dagger_hilt_room_basicskotlin.R
import pl.edu.uwr.pum.dagger_hilt_room_basicskotlin.data.Student

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: AppViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView = findViewById<TextView>(R.id.textview)

        viewModel.apply {
            insert(Student(0, "Rafa"))
            insert(Student(0, "Maciej"))
            insert(Student(0, "Kuba"))

            readAllData.observe(this@MainActivity) { student ->
                val content = StringBuilder()
                student.forEach {
                    content
                        .append("id: ").append(it.id).append("\n")
                        .append("Name: ").append(it.name).append("\n\n")
                }
                textView.text = content
            }
        }
    }
}