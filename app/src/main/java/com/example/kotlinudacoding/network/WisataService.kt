package com.example.kotlinudacoding.network

import com.example.kotlinudacoding.model.ResponseServer
import retrofit2.Call
import retrofit2.http.GET

interface WisataService {

    @GET("api?action=findAll")
    fun getDataWisata(): Call<ResponseServer>


}