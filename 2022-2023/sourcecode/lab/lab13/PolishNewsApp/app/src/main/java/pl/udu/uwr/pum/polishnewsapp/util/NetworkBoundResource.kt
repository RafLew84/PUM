package pl.udu.uwr.pum.polishnewsapp.util

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.channelFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

inline fun <ResultType, RequestType> networkBoundResource(
    crossinline query: () -> Flow<ResultType>,
    crossinline fetch: suspend () -> RequestType,
    crossinline saveFetchResult: suspend (RequestType) -> Unit,
    crossinline shouldFetch: (ResultType) -> Boolean = {true},
    crossinline fetchFailed: (Throwable) -> Unit = {},
    crossinline fetchSuccess: () -> Unit = {}
) = channelFlow {
    val data = query().first()
    if (shouldFetch(data)){
        val loading = launch { query().collect{send(Resource.Loading(it))} }
        try {
            saveFetchResult(fetch())
            fetchSuccess()
            loading.cancel()
            query().collect { send(Resource.Success(it)) }
        } catch (t: Throwable) {
            fetchFailed(t)
            loading.cancel()
            query().collect{send(Resource.Error(t, it))}
        }
    } else query().collect{send(Resource.Success(it))}
}