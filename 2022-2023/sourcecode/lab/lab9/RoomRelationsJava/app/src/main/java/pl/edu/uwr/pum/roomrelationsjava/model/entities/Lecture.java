package pl.edu.uwr.pum.roomrelationsjava.model.entities;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Lecture {

    @NonNull
    @PrimaryKey
    private final String lectureName;

    public Lecture(@NonNull String lectureName) {
        this.lectureName = lectureName;
    }

    @NonNull
    public String getLectureName() {
        return lectureName;
    }
}
