package pl.edu.uwr.pum.dagger_hilt_room_basicsjava.data.db;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import pl.edu.uwr.pum.dagger_hilt_room_basicsjava.data.Student;

@Database(entities = {Student.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase{

        public abstract AppDao appDao();

        private static volatile AppDatabase INSTANCE;

        private static final int NUMBER_OF_THREADS = 4;
        public static final ExecutorService databaseWriteExecutor =
                Executors.newFixedThreadPool(NUMBER_OF_THREADS);

        public static AppDatabase getDatabase(final Context context) {
            if (INSTANCE == null) {
                synchronized (AppDatabase.class) {
                    if (INSTANCE == null) {
                        INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                        AppDatabase.class, "student_database_java")
                                .build();
                    }
                }
            }
            return INSTANCE;
        }
}
