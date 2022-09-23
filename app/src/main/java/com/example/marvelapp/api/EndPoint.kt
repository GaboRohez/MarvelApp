package com.example.marvelapp.api

import com.example.marvelapp.Constants.Constants
import com.example.marvelapp.dto.ComicsResponse
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface EndPoint {

    @GET("v1/public/comics")
    fun getAllComics(
        @Query("apikey") apikey: String = Constants.API_KEY,
        @Query("ts") ts: String = Constants.timeStamp,
        @Query("hash") hash: String = Constants.hash()
    ): Single<Response<ComicsResponse>>
}