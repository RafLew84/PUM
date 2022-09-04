package pl.edu.uwr.pum.roomrelationskotlin.model.entity.relations

import androidx.room.Embedded
import androidx.room.Relation
import pl.edu.uwr.pum.roomrelationskotlin.model.entity.Dean
import pl.edu.uwr.pum.roomrelationskotlin.model.entity.Faculty

data class FacultyAndDean (
    @Embedded val faculty: Faculty,

    @Relation(
        parentColumn = "facultyName",
        entityColumn = "facultyName"
    )

    val dean: Dean
    )