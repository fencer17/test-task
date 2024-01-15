package com.example.testtask.domain.models

data class PhotoItem(
    val title: String,
    val browserLink: String,
    val imageLink: String,
    val dateTaken: String,
    val description: String,
    val published: Long,
    val author: String,
    val authorId: String,
    val tags: String
)
