package pl.edu.uwr.pum.roomrelationskotlin.model

import androidx.room.*
import pl.edu.uwr.pum.roomrelationskotlin.model.entity.Dean
import pl.edu.uwr.pum.roomrelationskotlin.model.entity.Faculty
import pl.edu.uwr.pum.roomrelationskotlin.model.entity.Lecture
import pl.edu.uwr.pum.roomrelationskotlin.model.entity.Student
import pl.edu.uwr.pum.roomrelationskotlin.model.entity.relations.*

@Dao
interface FacultyDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertFaculty(faculty: Faculty)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertDean(dean: Dean)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertStudent(student: Student)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertStudentLectureCrossRef(crossRef: StudentLectureCrossRef)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertLecture(lecture: Lecture)

    @Transaction
    @Query("SELECT * FROM faculty WHERE facultyName = :facultyName")
    fun getFacultyAndDean(facultyName: String): FacultyAndDean

    @Transaction
    @Query("SELECT * FROM student WHERE facultyName = :facultyName")
    fun getFacultyWithStudents(facultyName: String): List<FacultyWithStudents>

    @Transaction
    @Query("SELECT * FROM lecture WHERE lectureName = :lectureName")
    fun getStudentsOfLecture(lectureName: String): List<LectureWithStudents>

    @Transaction
    @Query("SELECT * FROM student WHERE studentName = :studentName")
    fun getLecturesOfStudent(studentName: String): List<StudentWithLectures>
}