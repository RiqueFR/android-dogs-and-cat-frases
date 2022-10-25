package com.example.teste

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.teste.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.storeButton.setOnClickListener(this)
    }

    override fun onClick(p0: View) {
        if (p0.id == R.id.store_button) {
            val name = binding.userInput.text.toString()
            if (name == "") {
                TODO("Avisar o usuário para preencher o nome")
                return
            }
            TODO("Guardar nome")
            startActivity(Intent(this, FrasesActivity::class.java))
            finish()
        }
    }
}