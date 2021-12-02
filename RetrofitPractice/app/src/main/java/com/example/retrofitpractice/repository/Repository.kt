package com.example.retrofitpractice.repository

import com.example.retrofitpractice.RetrofitInstance
import com.example.retrofitpractice.model.Todo
import retrofit2.Response

class Repository {

suspend fun getTodos() : Response<Todo>{

 return   RetrofitInstance.retrofit.getTodos()
}
}