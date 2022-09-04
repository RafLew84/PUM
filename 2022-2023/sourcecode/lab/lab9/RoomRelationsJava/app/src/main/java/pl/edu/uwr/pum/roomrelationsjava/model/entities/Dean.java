package pl.edu.uwr.pum.roomrelationsjava.model.entities;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Dean {

    @NonNull
    @PrimaryKey
    private final String deanName;

    @NonNull
    private final String facultyName;

    public Dean(@NonNull String deanName, @NonNull String facultyName){
        this.deanName = deanName;
        this.facultyName = facultyName;
    }

    @NonNull
    public String getDeanName() {
        return deanName;
    }

    @NonNull
    public String getFacultyName() {
        return facultyName;
    }
}
