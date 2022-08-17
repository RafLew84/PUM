package pl.edu.uwr.pum.sqlitekotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import pl.edu.uwr.pum.sqlitekotlin.adapter.StudentAdapter
import pl.edu.uwr.pum.sqlitekotlin.databinding.ActivityMainBinding
import pl.edu.uwr.pum.sqlitekotlin.db.DBHandler
import pl.edu.uwr.pum.sqlitekotlin.model.Student

class MainActivity : AppCompatActivity() {

    private val dbHandler by lazy { DBHandler(this) }
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.dataBaseRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = StudentAdapter(dbHandler, this@MainActivity)
        }

        binding.addButton.setOnClickListener {
            val name = binding.editTextName.text.toString()
            val index = binding.editTextIndex.text.toString()

            if (name.isNotEmpty() && index.isNotEmpty()){
                dbHandler.addStudent(Student(name, index.toInt()))
                binding.editTextName.text.clear()
                binding.editTextIndex.text.clear()
            }

            binding.dataBaseRecyclerView.adapter?.notifyItemInserted(dbHandler.getStudents().size)
        }
    }

    override fun onDestroy() {
        dbHandler.close()
        super.onDestroy()
    }
}