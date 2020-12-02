package com.example.kotlinudacoding.network

import com.example.kotlinudacoding.model.*
import retrofit2.Call
import retrofit2.http.*

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

    @GET("udacoding/pengunjung.php?")
    fun getDataPengunjung(@Query("action") action : String): Call<Pengunjung>

    @FormUrlEncoded
    @POST("udacoding/insertpengunjung.php?")
    fun getInsertPengunjung(@Field("action") action : String,
                            @Field("nama") nama : String,
                            @Field("alamat") alamat : String,
                            @Field("telp") telp : String): Call<Pengunjung>

    @POST("udacoding/pengunjung.php?")
    fun getEditPengunjung(@Field("action") action : String,
                          @Field("id") id : String,
                          @Field("nama") nama : String,
                          @Field("alamat") alamat : String,
                          @Field("telp") telp : String): Call<Pengunjung>

    @POST("udacoding/pengunjung.php?")
    fun getDeletePengunjung(@Field("action") action : String,
                            @Field("nama") nama : String,
                            @Field("alamat") alamat : String,
                            @Field("telp") telp : String): Call<Pengunjung>

}