package com.example.teste.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.teste.repository.api.client.ClientRetrofit
import com.example.teste.repository.api.model.CatDogEntity
import com.example.teste.repository.api.service.CatDogService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FrasesModel : ViewModel() {
    private var frase = MutableLiveData<String>()

    fun setMode(localMode : String) {
        if (localMode == "dog") {
            ClientRetrofit.setURL("https://www.dogfactsapi.ducnguyen.dev/api/v1/facts/?number=1")
        } else {
            ClientRetrofit.setURL("https://catfact.ninja/")
        }
    }

    fun getFrase() : LiveData<String> {
        return frase
    }

    fun getAPI() {
        val bpService = ClientRetrofit.createService(CatDogService::class.java)
        val listCall: Call<CatDogEntity> = bpService.getFact()
        listCall.enqueue(object : Callback<CatDogEntity> {
            override fun onResponse(
                call: Call<CatDogEntity>,
                response: Response<CatDogEntity>
            ) {
                frase.value = response.body()?.fact
                println(frase.value)
            }

            override fun onFailure(call: Call<CatDogEntity>, t: Throwable) {
                frase.value = "fail"
            }
        })
    }
}