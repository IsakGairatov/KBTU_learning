package com.example.apiassignment.data.api

import com.example.apiassignment.models.Manga
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MangaService {
    @GET("/api/mangas")
    fun getMangalist(
        @Query("page") page: Int = 1,
        @Query("limit") limit: Int = 50
    ) : Response<Manga>

}