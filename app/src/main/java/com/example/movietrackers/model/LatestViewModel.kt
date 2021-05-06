package com.example.movietrackers.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movietrackers.R
import com.example.movietrackers.data.TopRatedMovies
import com.example.movietrackers.network.LatestApi
import kotlinx.coroutines.launch

class LatestViewModel: ViewModel() {

    private val _latest = MutableLiveData<List<TopRatedMovies>>()
    val latest : LiveData<List<TopRatedMovies>> = _latest

    init {
        getLatest()
    }

    private fun getLatest()
    {
        try {
            viewModelScope.launch {
                _latest.value = LatestApi.retrofitService.getLatestMovies().results
            }
        }
        catch (e: Exception)
        {
            error(R.string.Error)
        }

    }
}