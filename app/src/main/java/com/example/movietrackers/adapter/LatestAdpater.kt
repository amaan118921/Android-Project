package com.example.movietrackers.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.ListAdapter
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movietrackers.R
import com.example.movietrackers.data.TopRatedMovies
import com.example.movietrackers.databinding.TopRatedItemBinding

class LatestAdpater(val context: Context): ListAdapter<TopRatedMovies, LatestAdpater.LatestViewHolder>(DiffCallback) {


    class LatestViewHolder(private var binding: TopRatedItemBinding): RecyclerView.ViewHolder(binding.root)
    {
        val Title: TextView = binding.movieName
        val Vote: TextView = binding.vote
        val imgView: ImageView = binding.eachView
        fun bind(popularMovies: TopRatedMovies)
        {

            binding.executePendingBindings()
        }
    }
    companion object DiffCallback: DiffUtil.ItemCallback<TopRatedMovies>() {
        override fun areItemsTheSame(oldItem: TopRatedMovies, newItem: TopRatedMovies): Boolean {
            return  oldItem.title==newItem.title
        }

        override fun areContentsTheSame(oldItem: TopRatedMovies, newItem: TopRatedMovies): Boolean {
            return oldItem.poster==newItem.poster
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LatestViewHolder {
        return LatestViewHolder(TopRatedItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: LatestViewHolder, position: Int) {
        val latest = getItem(position)
        val posterBaseUrl: String = "http://image.tmdb.org/t/p/w185"
        holder.Title.text = latest.title
        holder.Vote.text = latest.Vote
        Glide.with(context).load(posterBaseUrl + latest.poster).placeholder(R.drawable.loading_animation)
                .error(R.drawable.ic_broken_image).into(holder.imgView)
        holder.bind(latest)

    }
}