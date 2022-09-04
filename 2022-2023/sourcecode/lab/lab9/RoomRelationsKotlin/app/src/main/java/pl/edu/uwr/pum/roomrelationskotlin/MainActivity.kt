package pl.edu.uwr.pum.roomrelationskotlin

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import pl.edu.uwr.pum.roomrelationskotlin.model.FacultyRoomDatabase
import pl.edu.uwr.pum.roomrelationskotlin.model.entity.Dean
import pl.edu.uwr.pum.roomrelationskotlin.model.entity.Faculty
import pl.edu.uwr.pum.roomrelationskotlin.model.entity.Lecture
import pl.edu.uwr.pum.roomrelationskotlin.model.entity.Student
import pl.edu.uwr.pum.roomrelationskotlin.model.entity.relations.FacultyAndDean
import pl.edu.uwr.pum.roomrelationskotlin.model.entity.relations.StudentLectureCrossRef

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dao = FacultyRoomDatabase.getInstance(this).facultyDao

        val faculties = listOf(
            Faculty("Physics and Astronomy"),
            Faculty("Computer Science"),
            Faculty("Psychology")
        )

        val lectures = listOf(
            Lecture("PUM"),
            Lecture("C programming"),
            Lecture("Basic Psychology"),
            Lecture("Fundamental Physics")
        )

        val students = listOf(
            Student("Raf Lew", 1, "Physics and Astronomy"),
            Student("Lew Raf", 2, "Computer Science"),
            Student("R Lew", 3, "Physics and Astronomy"),
            Student("Raf L", 4, "Computer Science"),
            Student("Rafal Lew", 5, "Psychology"),
        )

        val deans = listOf(
            Dean("Marek P", "Computer Science"),
            Dean("Michal P", "Psychology"),
            Dean("Arek P", "Physics and Astronomy"),
        )

        val studentsLectureRelations = listOf(
            StudentLectureCrossRef("Raf Lew", "PUM"),
            StudentLectureCrossRef("Raf Lew", "C Programming"),
            StudentLectureCrossRef("Raf Lew", "Fundamental Physics"),
            StudentLectureCrossRef("R Lew", "PUM"),
            StudentLectureCrossRef("R Lew", "Basic Psychology"),
            StudentLectureCrossRef("Lew Raf", "PUM"),
            StudentLectureCrossRef("Lew Raf", "Fundamental Physics"),
            StudentLectureCrossRef("Raf L", "PUM")
        )

        lifecycleScope.launch{
            faculties.forEach { dao.insertFaculty(it) }
            deans.forEach { dao.insertDean(it) }
            students.forEach { dao.insertStudent(it) }
            lectures.forEach { dao.insertLecture(it) }
            studentsLectureRelations.forEach { dao.insertStudentLectureCrossRef(it) }
            val myFaculty: FacultyAndDean = dao.getFacultyAndDean("Physics and Astronomy")
            val t1 = findViewById<TextView>(R.id.textView1)
            val t2 = findViewById<TextView>(R.id.textView2)
            t1.text = myFaculty.faculty.facultyName
            t2.text = myFaculty.dean.deanName
        }
    }
}