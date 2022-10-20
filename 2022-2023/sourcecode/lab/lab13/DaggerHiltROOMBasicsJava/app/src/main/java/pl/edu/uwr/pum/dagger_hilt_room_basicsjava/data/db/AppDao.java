package pl.edu.uwr.pum.dagger_hilt_room_basicsjava.data.db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import pl.edu.uwr.pum.dagger_hilt_room_basicsjava.data.Student;

@Dao
public interface AppDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void addItem(Student student);

    @Query("SELECT * FROM student")
    LiveData<List<Student>> readAllData();
}
