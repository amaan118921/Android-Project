package com.example.movietrackers.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movietrackers.data.TopRatedMovies
import com.example.movietrackers.network.PopularApi
import kotlinx.coroutines.launch

class PopularViewModel: ViewModel() {
    var pageNo = (1..500).random()

    private val _popular = MutableLiveData<List<TopRatedMovies>>()
    val popular: LiveData<List<TopRatedMovies>> = _popular


    init {
        getPopular()
    }

     fun getPopular()
    {
        viewModelScope.launch {
            _popular.value = PopularApi.retrofitService.getPopularMovies(pageNo).results
        }
    }
}