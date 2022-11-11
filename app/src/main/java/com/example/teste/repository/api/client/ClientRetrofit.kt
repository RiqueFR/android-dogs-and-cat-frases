package com.example.teste.repository.api.client

import com.example.teste.repository.api.service.CatDogService
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ClientRetrofit {
    companion object {
        private lateinit var INSTANCE: Retrofit
        private var baseUrl = "https://catfact.ninja/"

        private fun getClientInstance(): Retrofit {
            val http = OkHttpClient.Builder()
            if (!::INSTANCE.isInitialized) {
                INSTANCE = Retrofit.Builder()
                        .baseUrl(baseUrl)
                        .client(http.build())
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
            }
            return INSTANCE
        }

        fun setURL(url : String) {
            baseUrl = url
        }

        fun <S> createService(className: Class<S>): S {
            return getClientInstance().create(className)
        }
    }
}