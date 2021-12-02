package com.example.retrofitpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.retrofitpractice.databinding.ActivityMainBinding
import com.example.retrofitpractice.repository.Repository

class MainActivity : AppCompatActivity() {
    private val TAG = "Responce"
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        val repository = Repository()
//        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.myResponse.observe(this, Observer { response->

            if(response.isSuccessful){
                Log.d(TAG,response.body()?.userId.toString())
                Log.d(TAG,response.body()?.id.toString())
                Log.d(TAG,response.body()?.title!!)
                Log.d(TAG,response.body()?.completed.toString())
            }
            else{
                Log.d(TAG,response.errorBody().toString())
                binding.TV1.text = response.code().toString()
            }
        }

        )

    }
}
