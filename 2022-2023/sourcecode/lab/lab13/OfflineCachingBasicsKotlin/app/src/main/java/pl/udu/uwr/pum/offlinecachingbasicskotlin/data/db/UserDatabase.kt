package pl.udu.uwr.pum.offlinecachingbasicskotlin.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import pl.udu.uwr.pum.offlinecachingbasicskotlin.data.User
import pl.udu.uwr.pum.offlinecachingbasicskotlin.data.converters.AddressConverter
import pl.udu.uwr.pum.offlinecachingbasicskotlin.data.converters.CreditCardConverter
import pl.udu.uwr.pum.offlinecachingbasicskotlin.data.converters.EmploymentConverter
import pl.udu.uwr.pum.offlinecachingbasicskotlin.data.converters.SubscriptionConverter

@Database(entities = [User::class], version = 1)
@TypeConverters(AddressConverter::class, CreditCardConverter::class, EmploymentConverter::class, SubscriptionConverter::class)
abstract class UserDatabase : RoomDatabase() {

    abstract fun usersDao(): UsersDao

    companion object {
        @Volatile
        private var INSTANCE: UserDatabase? = null

        fun getDatabase(context: Context): UserDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    UserDatabase::class.java,
                    "users_database_kotlin"
                ).build().also { INSTANCE = it }
                instance
            }
        }
    }
}