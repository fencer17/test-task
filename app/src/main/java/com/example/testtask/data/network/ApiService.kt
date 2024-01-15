package com.example.testtask.data.network

import com.example.testtask.data.network.responses.*
import retrofit2.Response
import retrofit2.http.*

interface ApiService {

    @GET("services/feeds/photos_public.gne?format=json&tags=cat&nojsoncallback=1")
    suspend fun getAlbum(): Response<AlbumDto>
}