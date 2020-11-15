package com.example.kotlinudacoding.network

import com.example.kotlinudacoding.model.ResponseServer
import retrofit2.Call
import retrofit2.http.GET

interface BatikService {

    @GET("api?action=all")
    fun getDataBatik(): Call<ResponseServer>


}