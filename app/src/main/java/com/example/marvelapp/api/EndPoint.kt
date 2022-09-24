package com.example.marvelapp.api

import com.example.marvelapp.dto.ComicsResponse
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface EndPoint {

    @GET("v1/public/comics")
    fun getAllComics(
        @Query("apikey") apikey: String,
        @Query("ts") ts: String,
        @Query("hash") hash: String,
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): Single<Response<ComicsResponse>>
}