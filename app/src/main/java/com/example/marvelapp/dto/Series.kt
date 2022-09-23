package com.example.marvelapp.dto

import com.google.gson.annotations.SerializedName


data class Series(

    @SerializedName("resourceURI")
    var resourceURI: String? = null,
    @SerializedName("name")
    var name: String? = null

)