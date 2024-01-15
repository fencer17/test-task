package com.example.testtask.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [
    AlbumEntity::class
], version = 1, exportSchema = false)

@TypeConverters(RoomConverters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun albumDao(): AlbumDao

    companion object {
        const val DATABASE_NAME: String = "test_task_db"
    }
}