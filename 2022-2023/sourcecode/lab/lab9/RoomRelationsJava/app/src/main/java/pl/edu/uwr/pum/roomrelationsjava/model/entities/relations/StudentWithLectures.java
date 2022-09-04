package pl.edu.uwr.pum.roomrelationsjava.model.entities.relations;

import androidx.room.Embedded;
import androidx.room.Junction;
import androidx.room.Relation;

import java.util.List;

import pl.edu.uwr.pum.roomrelationsjava.model.entities.Lecture;
import pl.edu.uwr.pum.roomrelationsjava.model.entities.Student;

public class StudentWithLectures {
    @Embedded
    public Student student;

    @Relation(
            parentColumn = "studentName",
            entityColumn = "lectureName",
            associateBy = @Junction(StudentLectureCrossRef.class)
    )

    public List<Lecture> lectureList;
}
