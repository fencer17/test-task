package com.example.testtask.data.db

import androidx.room.TypeConverter
import com.example.testtask.data.network.responses.PhotoItemDto
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

internal class RoomConverters {
    private val gson = Gson()

    //List<PhotoItemDto>
    @TypeConverter
    fun jsonStringToPhotoItemsDto(photoItemsStr: String?): List<PhotoItemDto>? {
        val type = object : TypeToken<List<PhotoItemDto>?>() {}.type
        return gson.fromJson(photoItemsStr, type)
    }

    @TypeConverter
    fun photoItemsDtoToJsonString(photoItemsDto: List<PhotoItemDto>?): String? {
        return gson.toJson(photoItemsDto)
    }
}