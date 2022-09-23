package com.example.marvelapp.dto

import com.google.gson.annotations.SerializedName


data class Creators(

    @SerializedName("available")
    var available: Int? = null,
    @SerializedName("collectionURI")
    var collectionURI: String? = null,
    @SerializedName("items")
    var items: ArrayList<Items> = arrayListOf()

)