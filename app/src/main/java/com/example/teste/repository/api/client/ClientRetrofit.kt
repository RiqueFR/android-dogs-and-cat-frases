package com.example.teste.repository.api.client

import com.example.teste.repository.api.service.CatService
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ClientRetrofit {
    companion object {
        private lateinit var INSTANCE: Retrofit
        private const val BASE_URL = "https://catfact.ninja/"

        private fun getClientInstance(): Retrofit {
            val http = OkHttpClient.Builder()
            if (!::INSTANCE.isInitialized) {
                INSTANCE = Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .client(http.build())
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
            }
            return INSTANCE
        }
    }

    fun <S> createService(className: Class<S>): S {
        return getRetrofitInstance().create(className)
    }
}