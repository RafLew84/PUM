package pl.edu.uwr.pum.roomrelationsjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import pl.edu.uwr.pum.roomrelationsjava.model.FacultyDao;
import pl.edu.uwr.pum.roomrelationsjava.model.FacultyRoomDatabase;
import pl.edu.uwr.pum.roomrelationsjava.model.entities.Dean;
import pl.edu.uwr.pum.roomrelationsjava.model.entities.Faculty;
import pl.edu.uwr.pum.roomrelationsjava.model.entities.Lecture;
import pl.edu.uwr.pum.roomrelationsjava.model.entities.Student;
import pl.edu.uwr.pum.roomrelationsjava.model.entities.relations.FacultyAndDean;
import pl.edu.uwr.pum.roomrelationsjava.model.entities.relations.StudentLectureCrossRef;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FacultyDao dao = FacultyRoomDatabase.getDatabase(this).facultyDao();

        FacultyRoomDatabase.dbWriteExecutor.execute(() ->{

            List<Faculty> faculties = new ArrayList<>();
            faculties.add(new Faculty("Physics and Astronomy"));
            faculties.add(new Faculty("Computer Science"));
            faculties.add(new Faculty("Psychology"));

            List<Dean> deans = new ArrayList<>();
            deans.add(new Dean("Marek P", "Computer Science"));
            deans.add(new Dean("Michal P", "Psychology"));
            deans.add(new Dean("Arek P", "Physics and Astronomy"));
            deans.add(new Dean("Arek L", "Physics"));

            List<Student> students = new ArrayList<>();
            students.add(new Student("Raf Lew", 1, "Physics and Astronomy"));
            students.add(new Student("Lew Raf", 2, "Computer Science"));
            students.add(new Student("R Lew", 3, "Physics and Astronomy"));
            students.add(new Student("Raf L", 4, "Computer Science"));
            students.add(new Student("Rafal Lew", 5, "Psychology"));

            List<Lecture> lectures = new ArrayList<>();
            lectures.add(new Lecture("PUM"));
            lectures.add(new Lecture("C programming"));
            lectures.add(new Lecture("Basic Psychology"));
            lectures.add(new Lecture("Fundamental Physics"));

            List<StudentLectureCrossRef> studentsLectureRelations = new ArrayList<>();
            studentsLectureRelations.add(new StudentLectureCrossRef("Raf Lew", "PUM"));
            studentsLectureRelations.add(new StudentLectureCrossRef("Raf Lew", "C Programming"));
            studentsLectureRelations.add(new StudentLectureCrossRef("Raf Lew", "Fundamental Physics"));
            studentsLectureRelations.add(new StudentLectureCrossRef("R Lew", "PUM"));
            studentsLectureRelations.add(new StudentLectureCrossRef("R Lew", "Basic Psychology"));
            studentsLectureRelations.add(new StudentLectureCrossRef("Lew Raf", "PUM"));
            studentsLectureRelations.add(new StudentLectureCrossRef("Lew Raf", "Fundamental Physics"));
            studentsLectureRelations.add(new StudentLectureCrossRef("Raf L", "PUM"));

            for(Dean d : deans)
                dao.insertDean(d);

            for(Faculty f : faculties)
                dao.insertFaculty(f);

            for(Student s : students)
                dao.insertStudent(s);

            for(Lecture l : lectures)
                dao.insertLecture(l);

            for(StudentLectureCrossRef sl : studentsLectureRelations)
                dao.insertStudentLectureCrossRef(sl);
        });
        FacultyRoomDatabase.dbWriteExecutor.execute(() -> {
            FacultyAndDean myFaculty = dao.getFacultyAndDean("Physics and Astronomy");
            TextView t1 = findViewById(R.id.textView1);
            TextView t2 = findViewById(R.id.textView2);
            t1.setText(myFaculty.faculty.getFacultyName());
            t2.setText(myFaculty.dean.getDeanName());
        });
    }
}