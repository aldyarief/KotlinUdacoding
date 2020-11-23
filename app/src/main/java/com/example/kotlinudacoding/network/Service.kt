package com.example.kotlinudacoding.network

import com.example.kotlinudacoding.model.*
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Service {

    @GET("batik/all")
    fun getDataBatik(): Call<Batik>

    @GET("api?action=findAll")
    fun getDataWisata(): Call<ResponseServer>

    @GET("api/daerahindonesia/provinsi")
    fun getDataDaerah(): Call<Daerah>

    @GET("api/prov.json")
    fun getDataCovid(): Call<Covid>

    @GET("api/index.php/CcariMuseum/searchGET?nama=museum")
    fun getDataMuseum(): Call<Museum>

    @GET("api/index.php/CcariMuseum/searchGET?nama=")
    fun getCariMuseum(@Query("nama") nama : String): Call<Museum>

}