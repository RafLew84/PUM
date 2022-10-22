package pl.udu.uwr.pum.offlinecachingbasicsjava.data.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import pl.udu.uwr.pum.offlinecachingbasicsjava.data.User;
import pl.udu.uwr.pum.offlinecachingbasicsjava.data.converters.AddressConverter;
import pl.udu.uwr.pum.offlinecachingbasicsjava.data.converters.CreditCardConverter;
import pl.udu.uwr.pum.offlinecachingbasicsjava.data.converters.EmploymentConverter;
import pl.udu.uwr.pum.offlinecachingbasicsjava.data.converters.SubscriptionConverter;

@Database(entities = {User.class}, version = 1, exportSchema = false)
@TypeConverters({AddressConverter.class, CreditCardConverter.class, EmploymentConverter.class, SubscriptionConverter.class})
public abstract class UserDatabase extends RoomDatabase {

    public abstract UserDao userDao();

    private static volatile UserDatabase INSTANCE;

    private static final int NUMBER_OF_THREADS = 4;
    public static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);
}
