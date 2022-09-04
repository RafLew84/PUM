package pl.edu.uwr.pum.roomrelationsjava.model.entities;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Student {

    @NonNull
    @PrimaryKey
    private final String studentName;
    private final int indexNumber;
    private final String facultyName;

    public Student(@NonNull String studentName, int indexNumber, String facultyName) {
        this.studentName = studentName;
        this.indexNumber = indexNumber;
        this.facultyName = facultyName;
    }

    @NonNull
    public String getStudentName() {
        return studentName;
    }

    public int getIndexNumber() {
        return indexNumber;
    }

    public String getFacultyName() {
        return facultyName;
    }
}

