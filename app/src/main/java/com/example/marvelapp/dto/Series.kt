package com.example.marvelapp.dto

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize


@Parcelize
data class Series(

    @SerializedName("resourceURI")
    var resourceURI: String? = null,
    @SerializedName("name")
    var name: String? = null

) : Parcelable