package com.example.teste

import kotlin.random.Random

class FrasesDog {
    val frases : List<String> = listOf(
        "Frase de cachorro 1",
        "Frase de cachorro 2",
        "Frase de cachorro 3",
        "Frase de cachorro 4"
    );

    fun getFrase() : String {
        val pos : Int = Random.nextInt(frases.size)
        return frases[pos]
    }
}