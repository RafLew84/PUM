package pl.edu.uwr.pum.roomrelationsjava.model.entities.relations;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;

@Entity(primaryKeys = {"studentName", "lectureName"})
public class StudentLectureCrossRef {
    @NonNull
    public String studentName;

    @NonNull
    @ColumnInfo(index = true)
    public String lectureName;

    public StudentLectureCrossRef(@NonNull String lectureName, @NonNull String studentName) {
        this.lectureName = lectureName;
        this.studentName = studentName;
    }
}
