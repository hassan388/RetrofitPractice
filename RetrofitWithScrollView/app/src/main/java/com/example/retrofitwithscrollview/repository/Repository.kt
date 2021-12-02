package com.example.retrofitwithscrollview.repository

import com.example.retrofitwithscrollview.RetrofitInstance
import com.example.retrofitwithscrollview.model.Todos
import retrofit2.Response

class Repository {

suspend fun getTodos() : Response<List<Todos>>{

    return RetrofitInstance.api.getTodos()
}

}