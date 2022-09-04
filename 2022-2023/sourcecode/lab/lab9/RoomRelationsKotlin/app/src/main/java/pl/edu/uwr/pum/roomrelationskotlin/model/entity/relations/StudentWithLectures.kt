package pl.edu.uwr.pum.roomrelationskotlin.model.entity.relations

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import pl.edu.uwr.pum.roomrelationskotlin.model.entity.Lecture
import pl.edu.uwr.pum.roomrelationskotlin.model.entity.Student

data class StudentWithLectures (
    @Embedded val student: Student,

    @Relation(
        parentColumn = "studentName",
        entityColumn = "lectureName",
        associateBy = Junction(StudentLectureCrossRef::class)
    )

    val lectures: List<Lecture>
    )