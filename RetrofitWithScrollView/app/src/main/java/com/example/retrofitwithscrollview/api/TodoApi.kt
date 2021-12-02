package com.example.retrofitwithscrollview.api

import com.example.retrofitwithscrollview.model.Todos
import retrofit2.Response
import retrofit2.http.GET

interface TodoApi {
    @GET("/todos")
    suspend fun getTodos() : Response<List<Todos>>
}