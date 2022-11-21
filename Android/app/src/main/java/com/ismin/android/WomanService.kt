package com.ismin.android

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface WomanService {
    @GET("women")
    fun getAllWomen(): Call<List<Woman>>

    @POST("women")
    fun createWoman(@Body() woman: Woman): Call<Woman>
}