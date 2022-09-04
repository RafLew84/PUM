package pl.edu.uwr.pum.roomrelationskotlin.model.entity.relations

import androidx.room.Embedded
import androidx.room.Relation
import pl.edu.uwr.pum.roomrelationskotlin.model.entity.Faculty
import pl.edu.uwr.pum.roomrelationskotlin.model.entity.Student

data class FacultyWithStudents (
    @Embedded val faculty: Faculty,

    @Relation(
        parentColumn = "facultyName",
        entityColumn = "facultyName"
    )

    val students: List<Student>
        )