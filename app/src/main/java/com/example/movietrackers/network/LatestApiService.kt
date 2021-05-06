package com.example.movietrackers.network

import com.example.movietrackers.data.Movies
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://api.themoviedb.org/"


private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

private val retrofit = Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .baseUrl(BASE_URL)
        .build()

interface LatestApiService {
    @GET("3/movie/latest?api_key=66748f45dd0711fc7ac50fa668b63b2b&language=en-US")
    suspend fun getLatestMovies() : Movies
}

object LatestApi {
    val retrofitService : LatestApiService by lazy { retrofit.create(LatestApiService::class.java) }
}