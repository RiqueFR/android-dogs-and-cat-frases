package com.example.teste

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.teste.repository.api.client.ClientRetrofit
import com.example.teste.repository.api.model.CatEntity
import com.example.teste.repository.api.service.CatService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.random.Random

class FrasesCat : ViewModel() {
    private var frase = MutableLiveData<String>()

    fun getFrase() : LiveData<String> {
        return frase
    }

    fun getAPI() {
        val bpService = ClientRetrofit.createService(CatService::class.java)
        val listCall: Call<CatEntity> = bpService.getFact()
        listCall.enqueue(object : Callback<CatEntity> {
            override fun onResponse(
                    call: Call<CatEntity>,
                    response: Response<CatEntity>
            ) {
                frase.value = response.body()?.fact
                println(frase.value)
            }

            override fun onFailure(call: Call<CatEntity>, t: Throwable) {
                frase.value = "fail"
            }
        })
    }
}