package com.example.movietrackers.data

import com.squareup.moshi.Json

data class TopRatedMovies(
    @Json(name="poster_path")val poster: String, val title: String, @Json(name="vote_average")val Vote: String
)

data class Movies(
    val results: List<TopRatedMovies>
)