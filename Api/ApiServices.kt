package com.example.pagination.Api

import okhttp3.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiServices {
    @GET("movies")
    suspend fun Get_Movie_List(@Query(value = "page")page:Int):retrofit2.Response<movie_responses>
}