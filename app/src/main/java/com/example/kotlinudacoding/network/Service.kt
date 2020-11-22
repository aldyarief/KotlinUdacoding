package com.example.kotlinudacoding.network

import com.example.kotlinudacoding.model.Batik
import com.example.kotlinudacoding.model.Daerah
import com.example.kotlinudacoding.model.ResponseServer
import retrofit2.Call
import retrofit2.http.GET

interface Service {

    @GET("batik/all")
    fun getDataBatik(): Call<Batik>

    @GET("api?action=findAll")
    fun getDataWisata(): Call<ResponseServer>

    @GET("api/daerahindonesia/provinsi")
    fun getDataDaerah(): Call<Daerah>

}