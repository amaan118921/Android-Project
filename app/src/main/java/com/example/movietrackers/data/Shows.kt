package com.example.movietrackers.data

import com.squareup.moshi.Json

data class Shows(
    val name: String,@Json(name="poster_path")val Poster: String, @Json(name="vote_average")val Vote: String
)

data class TV(
        val results: List<Shows>
)