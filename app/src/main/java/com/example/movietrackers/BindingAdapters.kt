package com.example.movietrackers

import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.movietrackers.adapter.*
import com.example.movietrackers.data.MovieDataClass
import com.example.movietrackers.data.Shows
import com.example.movietrackers.data.TopRatedMovies



@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<MovieDataClass>?) {
    val adapter = recyclerView.adapter as RecyclerViewAdapter
    adapter.submitList(data)
}


@BindingAdapter("imageUrl")
fun bindImage(imgView: ImageView, imgUrl: String?) {
    imgUrl?.let {
        val imgUri = imgUrl.toUri().buildUpon().scheme("https").build()
        imgView.load(imgUri) {
            placeholder(R.drawable.loading_animation)
            error(R.drawable.ic_broken_image)
        }
    }
}
////@BindingAdapter("topUrl")
////fun bindTop(imgView: ImageView, imgUrl: String?)
////{
////
////    imgUrl?.let {
////        val totalUrl = posterBaseUrl + imgUrl
////        val totalUri = totalUrl.toUri().buildUpon().scheme("https").build()
////        imgView.load(totalUri)
////        {
////            placeholder(R.drawable.loading_animation)
////            error(R.drawable.ic_broken_image)
////        }
////    }
//}
@BindingAdapter("TMDBdata")
fun bindData(recyclerView: RecyclerView, data:List<TopRatedMovies>?)
{
    val adapter = recyclerView.adapter as TopRatedApadter
    adapter.submitList(data)
}
@BindingAdapter("popularData")
fun bindPopular(recyclerView: RecyclerView, data:List<TopRatedMovies>?)
{
    val adapter = recyclerView.adapter as PopularAdapter
    adapter.submitList(data)
}
@BindingAdapter("latestData")
fun bindLatest(recyclerView: RecyclerView, data:List<TopRatedMovies>?)
{
    val adapter = recyclerView.adapter as LatestAdpater
    adapter.submitList(data)
}
@BindingAdapter("homeData")
fun bindHome(recyclerView: RecyclerView, data:List<Shows>?)
{
    val adapter = recyclerView.adapter as HomeAdapter
    adapter.submitList(data)
}