package com.example.movietrackers.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.movietrackers.R
import com.example.movietrackers.data.MovieDataClass
import com.example.movietrackers.databinding.ItemRecyclerViewBinding

class RecyclerViewAdapter(private val context: Context): ListAdapter<MovieDataClass, RecyclerViewAdapter.TVShowViewHolder> (DiffCallback) {

    class TVShowViewHolder(private var binding: ItemRecyclerViewBinding) : RecyclerView.ViewHolder(binding.root)
    {
        val statusText: TextView = binding.statusText
        val movieName: TextView = binding.movieName
            fun bind(tvShow: MovieDataClass)
            {
                binding.photo = tvShow
                binding.executePendingBindings()
            }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<MovieDataClass>(){
        override fun areItemsTheSame(oldItem: MovieDataClass, newItem: MovieDataClass): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: MovieDataClass, newItem: MovieDataClass): Boolean {
            return oldItem.name == newItem.name
        }

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TVShowViewHolder {
        return TVShowViewHolder(ItemRecyclerViewBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: TVShowViewHolder, position: Int) {
        val tvShow =getItem(position)
        holder.statusText.text = tvShow.status
        holder.movieName.text = tvShow.name
        holder.bind(tvShow)
    }
}