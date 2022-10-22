package pl.udu.uwr.pum.offlinecachingbasicskotlin.data.repository

import androidx.room.withTransaction
import pl.udu.uwr.pum.offlinecachingbasicskotlin.data.db.UserDatabase
import pl.udu.uwr.pum.offlinecachingbasicskotlin.data.remote.RandomApi
import pl.udu.uwr.pum.offlinecachingbasicskotlin.util.networkBoundResource
import javax.inject.Inject

class UserRepository @Inject constructor (
    private val api: RandomApi,
    private val db: UserDatabase
        ) {
    fun getUsers() = networkBoundResource(
        query = { db.usersDao().getUsers() },
        fetch = { api.users() },
        saveFetchResult = { users ->
            db.withTransaction {
                db.usersDao().apply {
                    clear()
                    insert(users)
                }
            }
        }
    )
}