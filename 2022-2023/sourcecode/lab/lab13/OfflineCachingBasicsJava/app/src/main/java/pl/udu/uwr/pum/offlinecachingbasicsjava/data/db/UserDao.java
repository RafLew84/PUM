package pl.udu.uwr.pum.offlinecachingbasicsjava.data.db;

import static androidx.room.OnConflictStrategy.REPLACE;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import pl.udu.uwr.pum.offlinecachingbasicsjava.data.User;

@Dao
public interface UserDao {
    @Insert(onConflict = REPLACE)
    void insert(List<User> users);

    @Query("DELETE FROM users")
    void clear();

    @Query("SELECT * FROM users")
    LiveData<List<User>> getUsers();
}
