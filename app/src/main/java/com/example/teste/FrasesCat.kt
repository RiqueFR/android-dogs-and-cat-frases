package com.example.teste

import com.example.teste.repository.api.service.CatService
import kotlin.random.Random

class FrasesCat {
    val frases : List<String> = listOf(
        "Frase de gato 1",
        "Frase de gato 2",
        "Frase de gato 3",
        "Frase de gato 4"
    );

    fun getFrase() : String {
        val pos : Int = Random.nextInt(frases.size)
        return frases[pos]
    }
    fun getAPI() : String {
        call.enqueue(object : Callback<CatService> {
            override fun onResponse(
                    call: Call<CatService>,
                    response: Response<CatService>
            ) {
                val list = response.body()
            }

            override fun onFailure(call: Call<CatService>, t: Throwable) {
                val s = ""
            }

        })

    }
}