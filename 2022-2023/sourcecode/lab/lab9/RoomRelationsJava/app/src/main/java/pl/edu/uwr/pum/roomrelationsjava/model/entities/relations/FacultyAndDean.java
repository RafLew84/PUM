package pl.edu.uwr.pum.roomrelationsjava.model.entities.relations;

import androidx.room.Embedded;
import androidx.room.Relation;

import pl.edu.uwr.pum.roomrelationsjava.model.entities.Dean;
import pl.edu.uwr.pum.roomrelationsjava.model.entities.Faculty;

public class FacultyAndDean {
    @Embedded
    public Faculty faculty;

    @Relation(
            parentColumn = "facultyName",
            entityColumn = "facultyName"
    )

    public Dean dean;
}
