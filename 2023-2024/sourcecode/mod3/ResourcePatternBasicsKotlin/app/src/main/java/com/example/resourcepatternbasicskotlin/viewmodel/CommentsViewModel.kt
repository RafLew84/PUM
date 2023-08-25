package com.example.resourcepatternbasicskotlin.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.resourcepatternbasicskotlin.data.CommentResponseItem
import com.example.resourcepatternbasicskotlin.data.repository.CommentRepository
import com.example.resourcepatternbasicskotlin.util.Resource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import retrofit2.Response

class CommentsViewModel : ViewModel() {
    private val repository = CommentRepository()
    private var _comments: MutableStateFlow<Resource<List<CommentResponseItem>>> = MutableStateFlow(Resource.Loading())
    val comments: StateFlow<Resource<List<CommentResponseItem>>> = _comments

    init {
        getCommentsList()
    }

    private fun getCommentsList() = viewModelScope.launch {
        _comments.value = Resource.Loading()
        val response = repository.getComments()
        _comments.value = handleCommentsResponse(response)
    }

    private fun handleCommentsResponse(response: Response<List<CommentResponseItem>>)
            : Resource<List<CommentResponseItem>> {
        if (response.isSuccessful)
            response.body()?.let { return Resource.Success(it) }
        return Resource.Error(response.message())
    }
}