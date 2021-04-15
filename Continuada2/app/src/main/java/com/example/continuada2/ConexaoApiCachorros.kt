package com.example.continuada2

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ConexaoApiCachorros {

    fun criar(): ApiCachorrro {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://5f861cfdc8a16a0016e6aacd.mockapi.io/bandtec-api/cachorros")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val api = retrofit.create(ApiCachorrro::class.java)

        return api
    }
}