package com.example.marvelapp.dto

import com.google.gson.annotations.SerializedName

data class Images(
    @SerializedName("path")
    var resourceURI: String? = null,
    @SerializedName("extension")
    var name: String? = null
)
