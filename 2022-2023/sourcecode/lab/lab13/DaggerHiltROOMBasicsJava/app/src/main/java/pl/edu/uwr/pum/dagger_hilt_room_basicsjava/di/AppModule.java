package pl.edu.uwr.pum.dagger_hilt_room_basicsjava.di;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import pl.edu.uwr.pum.dagger_hilt_room_basicsjava.data.db.AppDao;
import pl.edu.uwr.pum.dagger_hilt_room_basicsjava.data.db.AppDatabase;
import pl.edu.uwr.pum.dagger_hilt_room_basicsjava.data.repository.AppRepositoryImpl;
import pl.edu.uwr.pum.dagger_hilt_room_basicsjava.domain.repository.AppRepository;

@Module
@InstallIn(SingletonComponent.class)
public class AppModule {

    @Singleton
    @Provides
    AppDatabase getAppDB(Application app){
        return AppDatabase.getDatabase(app);
    }

    @Singleton
    @Provides
    AppDao getDao(AppDatabase db){
        return db.appDao();
    }

    @Singleton
    @Provides
    AppRepository provideAppRepository(AppDao appDao){
        return new AppRepositoryImpl(appDao);
    }
}
