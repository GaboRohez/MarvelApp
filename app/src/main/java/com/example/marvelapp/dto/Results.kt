package com.example.marvelapp.dto

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize


@Parcelize
data class Results(

    @SerializedName("id")
    var id: Int? = null,
    @SerializedName("digitalId")
    var digitalId: Int? = null,
    @SerializedName("title")
    var title: String? = null,
    @SerializedName("variantDescription")
    var variantDescription: String? = null,
    @SerializedName("description")
    var description: String? = null,
    @SerializedName("modified")
    var modified: String? = null,
    @SerializedName("format")
    var format: String? = null,
    @SerializedName("pageCount")
    var pageCount: Int? = null,
    @SerializedName("resourceURI")
    var resourceURI: String? = null,
    @SerializedName("series")
    var series: Series? = Series(),
    @SerializedName("prices")
    var prices: ArrayList<Prices> = arrayListOf(),
    @SerializedName("thumbnail")
    var thumbnail: Thumbnail? = Thumbnail(),
    @SerializedName("images")
    var images: ArrayList<Images> = arrayListOf(),
    @SerializedName("creators")
    var creators: Creators? = Creators()

) : Parcelable