package com.example.marvelapp.dto

import com.google.gson.annotations.SerializedName


data class ComicsResponse(

    @SerializedName("code")
    var code: Int? = null,
    @SerializedName("status")
    var status: String? = null,
    @SerializedName("copyright")
    var copyright: String? = null,
    @SerializedName("etag")
    var etag: String? = null,
    @SerializedName("data")
    var data: Data? = Data()

)