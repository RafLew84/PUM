package pl.edu.uwr.pum.dagger_hilt_room_basicsjava.data;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "student")
public class Student {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private final String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}
