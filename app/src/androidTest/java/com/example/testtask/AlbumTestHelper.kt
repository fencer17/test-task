package com.example.testtask

import com.example.testtask.data.db.AlbumEntity
import com.example.testtask.data.network.responses.MediaDto
import com.example.testtask.data.network.responses.PhotoItemDto

object AlbumTestHelper {

    fun getMockAlbum() = AlbumEntity(
        title = "Recent Uploads tagged cat",
        link = "https://www.flickr.com/photos/tags/cat/",
        description = "",
        modified = "2024-01-12T19:58:56Z",
        generator = "https://www.flickr.com",
        items = listOf(getMockPhotoItemDto()),
    )

    fun createMockAlbumList(size: Int): List<AlbumEntity> {
        val resultList = mutableListOf<AlbumEntity>()
        for (i in 0..< size) {
            resultList.add(getMockAlbum())
        }
        return resultList
    }

    private fun getMockPhotoItemDto() = PhotoItemDto(
        title = "chloe",
        link = "https://www.flickr.com/photos/_christine_s/53459820893/",
        media = MediaDto(""),
        dateTaken = "2023-06-12T04:44:28-08:00",
        description = "Test description",
        published = "2024-01-12T19:58:56Z",
        author = "nobody@flickr.com",
        authorId = "156443183",
        tags = "test tag"
    )

    fun AlbumEntity.equalsWithoutId(other: AlbumEntity?): Boolean {
        return title == other?.title
                && link == other.link
                && description == other.description
                && modified == other.modified
                && generator == other.generator
                && items == other.items
    }
}