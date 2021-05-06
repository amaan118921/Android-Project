package com.example.movietrackers.network

import com.example.movietrackers.data.Movies
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

private const val BASE_URL = "https://api.themoviedb.org/"


private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface tmdbApiService {
    @GET("3/movie/top_rated?api_key=66748f45dd0711fc7ac50fa668b63b2b&language=en-US")
    suspend fun getTopRatedMovies(@Query("page")pageNo:Int) : Movies

}
object TmdbApi {
    val retrofitService : tmdbApiService by lazy { retrofit.create(tmdbApiService::class.java) }
}

data class Url (
    val posterBaseUrl: String = "http://image.tmdb.org/t/p/w185"
        )