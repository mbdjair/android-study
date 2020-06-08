package com.djair.chucknorris.presentation.splash

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashViewModel : ViewModel() {


    private val _data: MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>().also {
            loadData(it)
        }
    }

    private val _loading: MutableLiveData<Boolean> =
        MutableLiveData<Boolean>().also {
            it.value = false
        }


    private fun loadData(it: MutableLiveData<Boolean>) {
        it.value = false
    }

    fun initApp() {
        viewModelScope.launch {
            delay(1000)
            _data.postValue(true)
        }
    }

    val data: LiveData<Boolean> = _data

}