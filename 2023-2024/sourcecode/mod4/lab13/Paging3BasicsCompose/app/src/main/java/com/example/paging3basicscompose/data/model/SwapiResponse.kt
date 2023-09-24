package com.example.paging3basicscompose.data.model

data class SwapiResponse(
    val count: Int,
    val next: String?,
    val previous: String?,
    val results: List<Result>
)