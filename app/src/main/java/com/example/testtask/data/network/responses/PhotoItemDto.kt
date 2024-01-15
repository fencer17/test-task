package com.example.testtask.data.network.responses

import com.squareup.moshi.Json

data class PhotoItemDto(
    val title: String,
    val link: String,
    val media: MediaDto,
    @Json(name="date_taken")
    val dateTaken: String,
    val description: String,
    val published: String,
    val author: String,
    @Json(name="author_id")
    val authorId: String,
    val tags: String
)

data class MediaDto(
    val m: String
)