package pl.udu.uwr.pum.polishnewsapp.data.repo

import pl.udu.uwr.pum.polishnewsapp.data.api.NewsApi
import pl.udu.uwr.pum.polishnewsapp.data.db.ArticlesDatabase
import javax.inject.Inject

class NewsRepository @Inject constructor (
    private val api: NewsApi,
    private val db: ArticlesDatabase
) {}