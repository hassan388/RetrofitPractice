package com.example.retrofitpractice

import com.example.retrofitpractice.api.NewApi
import com.example.retrofitpractice.utils.Constants.Companion.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    val retrofit: NewApi by lazy{

        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewApi::class.java)
    }
}