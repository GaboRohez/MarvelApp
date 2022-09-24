package com.example.marvelapp.dto

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Images(
    @SerializedName("path")
    var resourceURI: String? = null,
    @SerializedName("extension")
    var name: String? = null
) : Parcelable
