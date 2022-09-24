package com.example.marvelapp.dto

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize


@Parcelize
data class Items(

    @SerializedName("resourceURI")
    var resourceURI: String? = null,
    @SerializedName("name")
    var name: String? = null,
    @SerializedName("role")
    var role: String? = null

) : Parcelable