package com.example.teste.repository.api.service
import com.example.teste.repository.api.model.CatEntity
import retrofit2.Call
import retrofit2.http.GET

interface CatService {
    @GET("fact")
    fun getFact(): Call<CatEntity>
}