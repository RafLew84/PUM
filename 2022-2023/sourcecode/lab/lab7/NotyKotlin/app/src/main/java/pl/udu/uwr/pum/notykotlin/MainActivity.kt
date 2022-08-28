package pl.udu.uwr.pum.notykotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import pl.udu.uwr.pum.notykotlin.data.DataProvider
import pl.udu.uwr.pum.notykotlin.db.DBHandler

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val dbHandler = DBHandler(this)
        DataProvider.notes.forEach { dbHandler.addNote(it) }
        dbHandler.close()
    }
}