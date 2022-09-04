package pl.edu.uwr.pum.roomrelationsjava.model.entities.relations;

import androidx.room.Embedded;
import androidx.room.Junction;
import androidx.room.Relation;

import java.util.List;

import pl.edu.uwr.pum.roomrelationsjava.model.entities.Lecture;
import pl.edu.uwr.pum.roomrelationsjava.model.entities.Student;

public class LectureWithStudents {
    @Embedded
    public Lecture lecture;

    @Relation(
            parentColumn = "lectureName",
            entityColumn = "studentName",
            associateBy = @Junction(StudentLectureCrossRef.class)
    )

    public List<Student> studentList;
}
