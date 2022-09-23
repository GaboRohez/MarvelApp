package com.example.marvelapp.dto

import com.google.gson.annotations.SerializedName


data class Prices(

    @SerializedName("type")
    var type: String? = null,
    @SerializedName("price")
    var price: Float? = null

)