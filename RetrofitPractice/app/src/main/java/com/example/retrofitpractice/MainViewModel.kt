package com.example.retrofitpractice

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofitpractice.model.Todo
import com.example.retrofitpractice.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel() : ViewModel() {

    val myResponse: MutableLiveData<Response<Todo>> = MutableLiveData()
    private var repository: Repository = Repository()

    fun getTodos() {

        viewModelScope.launch {
            val response = repository.getTodos()
            myResponse.value = response
        }
    }
}