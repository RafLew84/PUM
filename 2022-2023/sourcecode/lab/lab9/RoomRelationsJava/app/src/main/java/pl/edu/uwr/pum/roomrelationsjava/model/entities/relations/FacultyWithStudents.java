package pl.edu.uwr.pum.roomrelationsjava.model.entities.relations;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.List;

import pl.edu.uwr.pum.roomrelationsjava.model.entities.Faculty;
import pl.edu.uwr.pum.roomrelationsjava.model.entities.Student;

public class FacultyWithStudents {
    @Embedded
    public Faculty faculty;

    @Relation(
            parentColumn = "facultyName",
            entityColumn = "facultyName"
    )

    public List<Student> studentList;
}
