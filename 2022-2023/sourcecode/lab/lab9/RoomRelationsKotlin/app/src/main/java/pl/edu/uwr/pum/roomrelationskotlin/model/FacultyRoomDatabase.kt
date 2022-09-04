package pl.edu.uwr.pum.roomrelationskotlin.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import pl.edu.uwr.pum.roomrelationskotlin.model.entity.Dean
import pl.edu.uwr.pum.roomrelationskotlin.model.entity.Faculty
import pl.edu.uwr.pum.roomrelationskotlin.model.entity.Lecture
import pl.edu.uwr.pum.roomrelationskotlin.model.entity.Student
import pl.edu.uwr.pum.roomrelationskotlin.model.entity.relations.StudentLectureCrossRef

@Database(
    entities = [
        Faculty::class,
        Dean::class,
        Student::class,
        Lecture::class,
        StudentLectureCrossRef::class
    ],
    version = 1,
    exportSchema = false
)
abstract class FacultyRoomDatabase : RoomDatabase() {
    abstract val facultyDao: FacultyDao

    companion object{
        @Volatile
        private var INSTANCE: FacultyRoomDatabase? = null

        fun getInstance(context: Context): FacultyRoomDatabase{
            synchronized(this){
                return  INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    FacultyRoomDatabase::class.java,
                    "kotlin_faculty_db"
                ).build().also {
                    INSTANCE = it
                }
            }
        }
    }
}