package com.example.testtask.data.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.testtask.data.network.responses.MediaDto
import com.example.testtask.data.network.responses.PhotoItemDto

@Entity(tableName = "albums")
data class AlbumEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    val link: String,
    val description: String,
    val modified: String,
    val generator: String,
    val items: List<PhotoItemDto>
)