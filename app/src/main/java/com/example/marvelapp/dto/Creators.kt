package com.example.marvelapp.dto

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize


@Parcelize
data class Creators(

    @SerializedName("available")
    var available: Int? = null,
    @SerializedName("collectionURI")
    var collectionURI: String? = null,
    @SerializedName("items")
    var items: ArrayList<Items> = arrayListOf()

) : Parcelable