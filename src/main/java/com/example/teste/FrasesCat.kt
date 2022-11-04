package com.example.teste

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
}