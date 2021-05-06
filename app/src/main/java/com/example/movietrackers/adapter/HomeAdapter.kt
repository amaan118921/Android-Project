package com.example.movietrackers.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movietrackers.R
import com.example.movietrackers.data.Shows

import com.example.movietrackers.databinding.TopRatedItemBinding

class HomeAdapter(val context: Context): ListAdapter<Shows, HomeAdapter.HomeViewHolder>(DiffCallback) {
    class HomeViewHolder(private var binding: TopRatedItemBinding) : RecyclerView.ViewHolder(binding.root)
    {
        val Title: TextView = binding.movieName
        val vote: TextView = binding.vote
        val imgView: ImageView = binding.eachView
        fun bind(home: Shows)
        {
           binding.executePendingBindings()
        }

    }

    companion object DiffCallback: DiffUtil.ItemCallback<Shows>() {
        override fun areItemsTheSame(oldItem: Shows, newItem: Shows): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: Shows, newItem: Shows): Boolean {
            return oldItem.name==newItem.name
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
       return HomeViewHolder(TopRatedItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        val posterBaseUrl = "http://image.tmdb.org/t/p/w185"
       val Home = getItem(position)
        holder.Title.text = Home.name
        holder.vote.text = Home.Vote
        Glide.with(context).load(posterBaseUrl + Home.Poster).placeholder(R.drawable.loading_animation).
        error(R.drawable.ic_broken_image).into(holder.imgView)

        holder.bind(Home)
    }
}