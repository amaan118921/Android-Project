package com.example.movietrackers.network

import com.example.movietrackers.HomeFragment
import com.example.movietrackers.data.TVShow
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

private const val BASE_URL = "https://www.episodate.com/"


/**
 * Build the Moshi object that Retrofit will be using, making sure to add the Kotlin adapter for
 * full Kotlin compatibility.
 */
private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

/**
 * Use the Retrofit builder to build a com.example.movietrackers.network.retrofit object using a Moshi converter with our Moshi
 * object.
 */

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()


/**
 * A public interface that exposes the [getPhotos] method
 */
interface ApiService {

    @GET("api/most-popular")
    suspend fun getPhotos(@Query("page")pageNo:Int): TVShow
}


object MovieApi {
    val retrofitService: ApiService by lazy { retrofit.create(ApiService::class.java) }

}
