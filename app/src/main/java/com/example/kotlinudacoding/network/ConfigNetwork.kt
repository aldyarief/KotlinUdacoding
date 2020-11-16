package com.example.kotlinudacoding.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ConfigNetwork {

    companion object {
        fun getRetrofit(): BatikService {
            val retrofit = Retrofit.Builder()
                .baseUrl("http://batikita.herokuapp.com/index.php/batik/all/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            val service = retrofit.create(BatikService::class.java)

            return service
        }
    }
}