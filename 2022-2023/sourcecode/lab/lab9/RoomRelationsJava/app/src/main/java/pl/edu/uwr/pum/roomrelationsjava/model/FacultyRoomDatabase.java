package pl.edu.uwr.pum.roomrelationsjava.model;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import pl.edu.uwr.pum.roomrelationsjava.model.entities.Dean;
import pl.edu.uwr.pum.roomrelationsjava.model.entities.Faculty;
import pl.edu.uwr.pum.roomrelationsjava.model.entities.Lecture;
import pl.edu.uwr.pum.roomrelationsjava.model.entities.Student;
import pl.edu.uwr.pum.roomrelationsjava.model.entities.relations.StudentLectureCrossRef;

@Database(
        entities = {
                Faculty.class,
                Student.class,
                Dean.class,
                Lecture.class,
                StudentLectureCrossRef.class
        },
        version = 3,
        exportSchema = false
)
abstract public class FacultyRoomDatabase extends RoomDatabase {
    public abstract FacultyDao facultyDao();

    private static volatile FacultyRoomDatabase INSTANCE;
    private static final int NUM_OF_THREADS = 4;

    public static final ExecutorService dbWriteExecutor = Executors.newFixedThreadPool(NUM_OF_THREADS);

    public static FacultyRoomDatabase getDatabase(final Context context){
        if(INSTANCE == null){
            INSTANCE = Room
                    .databaseBuilder(context.getApplicationContext(),
                            FacultyRoomDatabase.class,
                            "dbv2")
                    .build();
        }

        return INSTANCE;
    }
}
