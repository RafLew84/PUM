package com.example.paging3basicscompose.ui.screens.list

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.paging3basicscompose.data.api.SwapiApiService
import com.example.paging3basicscompose.data.model.Result
import com.example.paging3basicscompose.data.repository.SwapiRepository
import java.util.regex.Pattern

class CharactersPagingSource(
    private val repository: SwapiRepository
) : PagingSource<Int, Result>() {
    override fun getRefreshKey(state: PagingState<Int, Result>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Result> {
        return try {
            val page = params.key ?: 1
            val response = repository.getCharacters(page)

            Log.d("data", "page: ${response.results}")

            LoadResult.Page(
                data = response.results,
                prevKey = getPageNumberFromUrl(response.previous),
                nextKey = getPageNumberFromUrl(response.next),
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    private fun getPageNumberFromUrl(url: String?): Int? {
        if (url != null) {
            val pattern = Pattern.compile("page=(\\d+)")
            val matcher = pattern.matcher(url)

            if (matcher.find()) {
                val pageNumberString = matcher.group(1)
                if (pageNumberString != null) {
                    return pageNumberString.toInt()
                }
            }
        }

        return null
    }
}