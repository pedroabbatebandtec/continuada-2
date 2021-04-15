package com.example.continuada2

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiCachorrro {

    @GET("cachorros")
    fun get(): Call<List<Cachorro>>

    @GET("cachorro/{id}")
    fun get(@Path("id") id: Int): Call<Cachorro>
}