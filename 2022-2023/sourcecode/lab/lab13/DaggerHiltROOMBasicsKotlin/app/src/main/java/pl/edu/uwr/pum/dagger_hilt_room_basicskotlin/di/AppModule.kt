package pl.edu.uwr.pum.dagger_hilt_room_basicskotlin.di

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import pl.edu.uwr.pum.dagger_hilt_room_basicskotlin.data.db.AppDao
import pl.edu.uwr.pum.dagger_hilt_room_basicskotlin.data.db.AppDatabase
import pl.edu.uwr.pum.dagger_hilt_room_basicskotlin.data.repository.AppRepositoryImpl
import pl.edu.uwr.pum.dagger_hilt_room_basicskotlin.domain.repository.AppRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun getAppDB(app: Application): AppDatabase{
        return AppDatabase.getDatabase(app)
    }

    @Singleton
    @Provides
    fun getDao(db: AppDatabase): AppDao{
        return db.appDao()
    }

    @Singleton
    @Provides
    fun provideAppRepository(appDao: AppDao) : AppRepository {
        return AppRepositoryImpl(appDao)
    }
}