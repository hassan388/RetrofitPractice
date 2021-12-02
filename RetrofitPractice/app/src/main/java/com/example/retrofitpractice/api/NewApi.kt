package com.example.retrofitpractice.api

import com.example.retrofitpractice.model.Todo
import retrofit2.Response
import retrofit2.http.GET

interface NewApi {

    @GET("todos/1")
    suspend fun getTodos() : Response<Todo>
}