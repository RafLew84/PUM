package pl.edu.uwr.pum.roomrelationskotlin.model.entity.relations

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import pl.edu.uwr.pum.roomrelationskotlin.model.entity.Lecture
import pl.edu.uwr.pum.roomrelationskotlin.model.entity.Student

data class LectureWithStudents (
    @Embedded val lecture: Lecture,

    @Relation(
        parentColumn = "lectureName",
        entityColumn = "studentName",
        associateBy = Junction(StudentLectureCrossRef::class)
    )

    val students: List<Student>
        )