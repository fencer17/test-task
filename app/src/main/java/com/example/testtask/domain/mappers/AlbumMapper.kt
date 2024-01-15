package com.example.testtask.domain.mappers

import com.example.testtask.core.utils.FormatUtils
import com.example.testtask.data.db.AlbumEntity
import com.example.testtask.data.network.responses.AlbumDto
import com.example.testtask.data.network.responses.PhotoItemDto
import com.example.testtask.domain.models.Album
import com.example.testtask.domain.models.PhotoItem

fun AlbumDto.toAlbumEntity() = AlbumEntity(
      title = title,
      link = link,
      description = description,
      modified = modified,
      generator = generator,
      items = items
)

fun AlbumEntity.toAlbum() = Album(
      title = title,
      link = link,
      description = description,
      modified = modified,
      generator = generator,
      items = items.map { it.toPhotoItem() }
)

fun PhotoItemDto.toPhotoItem() = PhotoItem(
      title = title,
      browserLink = link,
      imageLink = media.m,
      dateTaken = dateTaken,
      description = description,
      published = FormatUtils.formatDateStringToMillis(published),
      author = author,
      authorId = authorId,
      tags = tags,
)