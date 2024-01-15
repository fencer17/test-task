package com.example.testtask.domain.repos

import com.example.testtask.data.db.AlbumDao
import com.example.testtask.data.network.ApiService
import com.example.testtask.domain.mappers.toAlbum
import com.example.testtask.domain.mappers.toAlbumEntity
import com.example.testtask.domain.models.Album
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AlbumRepository @Inject constructor(
    private val apiService: ApiService,
    private val albumDao: AlbumDao
) {

    /**
     * We save in database entire json object so therefore it's album object instead of simple list of photos.
     * This approach makes code more flexible and scalable.
     * For instance if you want to add new albums you don't need to insert only new photos to the same table in database.
     * Instead of it we save new album object, so now we can choose album first and then show photos from this album
     * */
    suspend fun syncAlbumsList() {
        try {
            apiService.getAlbum().body()?.toAlbumEntity()?.let { album ->
                albumDao.deleteAndInsert(album)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    /**
     * Here we get first album since we save only one from request
     * */
    fun getAlbumFlow(): Flow<Album?> {
        return albumDao.getAlbumListFlow().map { it?.firstOrNull()?.toAlbum() }
    }
}