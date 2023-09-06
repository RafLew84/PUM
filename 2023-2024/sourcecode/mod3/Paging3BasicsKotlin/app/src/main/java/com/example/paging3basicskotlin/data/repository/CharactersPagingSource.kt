package com.example.paging3basicskotlin.data.repository

import androidx.paging.PagingSource
import androidx.paging.PagingState
import java.util.regex.Pattern
import com.example.paging3basicskotlin.data.model.Result

class CharactersPagingSource(
    private val repository: SwapiRepository
) : PagingSource<Int, Result>() {
    override fun getRefreshKey(state: PagingState<Int, Result>): Int? {
        return state.anchorPosition ?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Result> {
        return try {
            val page = params.key ?: 1
            val response = repository.getCharacters(page)

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