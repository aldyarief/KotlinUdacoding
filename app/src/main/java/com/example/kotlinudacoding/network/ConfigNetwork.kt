package com.example.kotlinudacoding.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ConfigNetwork {

    companion object {
        fun getRetrofit(): Service {
            val retrofit = Retrofit.Builder()
                .baseUrl("http://batikita.herokuapp.com/index.php/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            val service = retrofit.create(Service::class.java)

            return service
        }
    }
}