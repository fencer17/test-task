package com.example.testtask.data.db

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface AlbumDao {
    @Query("SELECT * FROM albums")
    fun getAlbumListFlow(): Flow<List<AlbumEntity>?>

    @Query("SELECT * FROM albums")
    suspend fun getAlbumList(): List<AlbumEntity>?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(vararg albumEntity: AlbumEntity)

    @Update
    suspend fun update(albumEntity: AlbumEntity)

    @Delete
    suspend fun delete(albumEntity: AlbumEntity)

    @Query("DELETE FROM albums")
    suspend fun deleteAll()

    @Transaction
    suspend fun deleteAndInsert(albumEntity: AlbumEntity) {
        deleteAll()
        insert(albumEntity)
    }
}