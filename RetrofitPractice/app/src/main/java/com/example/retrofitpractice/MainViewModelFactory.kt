package com.example.retrofitpractice

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.retrofitpractice.repository.Repository

class MainViewModelFactory(private val repos: Repository): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(repos) as T
    }
}