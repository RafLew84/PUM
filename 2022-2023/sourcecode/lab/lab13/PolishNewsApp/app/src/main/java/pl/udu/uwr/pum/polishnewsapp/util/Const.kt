package pl.udu.uwr.pum.polishnewsapp.util

import pl.udu.uwr.pum.polishnewsapp.BuildConfig
import java.util.concurrent.TimeUnit

const val BASE_URL = "https://newsdata.io/api/1/"
const val API_KEY = BuildConfig.NEWS_DATA_IO_KEY
const val DATABASE_NAME = "articles_database_v2"
val TIME_TO_REFRESH_DATA = TimeUnit.MINUTES.toMillis(10)
val TIME_TO_DELETE_NOT_FAVORITE_ARTICLES = TimeUnit.DAYS.toMillis(1)