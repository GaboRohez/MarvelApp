package com.example.marvelapp.dto

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize


@Parcelize
data class Prices(

    @SerializedName("type")
    var type: String? = null,
    @SerializedName("price")
    var price: Float? = null

) : Parcelable