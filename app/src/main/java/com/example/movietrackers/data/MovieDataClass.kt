package com.example.movietrackers.data

import com.squareup.moshi.Json


data class MovieDataClass(

    val id : String, val name: String, val permalink: String, val country: String,
    val network: String, val status: String, @Json(name = "image_thumbnail_path")val imageUrl: String
)

data class TVShow(
    @Json(name="tv_shows")val tvShow: List<MovieDataClass>

)

