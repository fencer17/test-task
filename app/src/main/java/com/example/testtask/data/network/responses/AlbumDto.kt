package com.example.testtask.data.network.responses

data class AlbumDto(
    val title: String,
    val link: String,
    val description: String,
    val modified: String,
    val generator: String,
    val items: List<PhotoItemDto>
)