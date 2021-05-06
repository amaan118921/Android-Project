package com.example.movietrackers.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movietrackers.R
import com.example.movietrackers.data.TopRatedMovies
import com.example.movietrackers.databinding.TopRatedItemBinding

class TopRatedApadter(val context:Context): ListAdapter<TopRatedMovies, TopRatedApadter.TopRatedViewHolder> (DiffCallback) {

    class TopRatedViewHolder(private var binding: TopRatedItemBinding): RecyclerView.ViewHolder(binding.root)
    {
        val Title: TextView  = binding.movieName
        val Vote: TextView = binding.vote
        val imgView: ImageView = binding.eachView
        fun bind(topRated: TopRatedMovies)
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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopRatedViewHolder {
        return TopRatedViewHolder(TopRatedItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: TopRatedViewHolder, position: Int) {
        val top = getItem(position)
        val posterBaseUrl = "http://image.tmdb.org/t/p/w185"
        holder.Title.text = top.title
        holder.Vote.text = top.Vote
        Glide.with(context).load(posterBaseUrl + top.poster).placeholder(R.drawable.loading_animation)
            .error(R.drawable.ic_broken_image).into(holder.imgView)
        holder.bind(top)

    }
}