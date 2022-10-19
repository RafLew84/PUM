package pl.edu.uwr.pum.dagger_hilt_room_basicskotlin.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import pl.edu.uwr.pum.dagger_hilt_room_basicskotlin.data.Student

@Database(entities = [Student::class], version = 1)
abstract class AppDatabase() : RoomDatabase() {

    abstract fun appDao(): AppDao

    companion object{
        @Volatile private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "student_database_kotlin"
                ).build().also { INSTANCE = it }
                instance
            }
        }
    }
}