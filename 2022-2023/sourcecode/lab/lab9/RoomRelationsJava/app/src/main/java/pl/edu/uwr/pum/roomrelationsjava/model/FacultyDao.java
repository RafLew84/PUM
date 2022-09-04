package pl.edu.uwr.pum.roomrelationsjava.model;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;

import java.util.List;

import pl.edu.uwr.pum.roomrelationsjava.model.entities.Dean;
import pl.edu.uwr.pum.roomrelationsjava.model.entities.Faculty;
import pl.edu.uwr.pum.roomrelationsjava.model.entities.Lecture;
import pl.edu.uwr.pum.roomrelationsjava.model.entities.Student;
import pl.edu.uwr.pum.roomrelationsjava.model.entities.relations.FacultyAndDean;
import pl.edu.uwr.pum.roomrelationsjava.model.entities.relations.FacultyWithStudents;
import pl.edu.uwr.pum.roomrelationsjava.model.entities.relations.LectureWithStudents;
import pl.edu.uwr.pum.roomrelationsjava.model.entities.relations.StudentLectureCrossRef;
import pl.edu.uwr.pum.roomrelationsjava.model.entities.relations.StudentWithLectures;

@Dao
public interface FacultyDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertFaculty(Faculty faculty);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertDean(Dean dean);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertStudent(Student student);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertStudentLectureCrossRef(StudentLectureCrossRef crossRef);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertLecture(Lecture lecture);

    @Transaction
    @Query("SELECT * FROM faculty WHERE facultyName = :facultyName")
    FacultyAndDean getFacultyAndDean(String facultyName);

    @Transaction
    @Query("SELECT * FROM student WHERE facultyName = :facultyName")
    List<FacultyWithStudents> getFacultyWithStudents(String facultyName);

    @Transaction
    @Query("SELECT * FROM lecture WHERE lectureName = :lectureName")
    List<LectureWithStudents> getStudentsOfLecture(String lectureName);

    @Transaction
    @Query("SELECT * FROM student WHERE studentName = :studentName")
    List<StudentWithLectures> getLecturesOfStudent(String studentName);
}