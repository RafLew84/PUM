package pl.edu.uwr.pum.roomrelationsjava.model.entities;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Faculty {

    @NonNull
    @PrimaryKey
    private final String facultyName;

    public Faculty(@NonNull String facultyName) {
        this.facultyName = facultyName;
    }

    @NonNull
    public String getFacultyName() {
        return facultyName;
    }
}
