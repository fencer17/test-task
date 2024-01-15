package com.example.testtask.domain.models

data class Album(
    val title: String,
    val link: String,
    val description: String,
    val modified: String,
    val generator: String,
    val items: List<PhotoItem>
)
