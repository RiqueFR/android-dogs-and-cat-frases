package com.example.teste.repository.api.service
import com.example.teste.repository.api.model.CatDogEntity
import retrofit2.Call
import retrofit2.http.GET

interface CatDogService {
    @GET("fact")
    fun getFact(): Call<CatDogEntity>
}