package com.djair.chucknorris.presentation.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.djair.chucknorris.domain.config.Result
import com.djair.chucknorris.domain.repository.JokeRepository
import kotlinx.coroutines.launch

class HomeViewModel(private val repository: JokeRepository) : ViewModel() {


    private val _data: MutableLiveData<String> by lazy {
        MutableLiveData<String>().also {
            loadData(it)
        }
    }

    private val _loading: MutableLiveData<Boolean> =
        MutableLiveData<Boolean>().also {
            it.value = false
        }

    fun newJoke() {
        _loading.value = true
        viewModelScope.launch {
            val result = repository.fetch()
            postResult(result)
            _loading.postValue(false)
        }
    }

    private fun postResult(result: Result<String>) {
        val data = when (result) {
            is Result.Success -> result.data
            is Result.Error<*> -> result.error.message
        }
        _data.postValue(data)
    }

    private fun loadData(it: MutableLiveData<String>) {
        it.value = "Jokee"
    }

    val data: LiveData<String> = _data

    val loading: LiveData<Boolean> = _loading
}