package com.example.teste.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.teste.Constants
import com.example.teste.R
import com.example.teste.UserPreferences
import com.example.teste.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.storeButton.setOnClickListener(this)

        val userPref = UserPreferences(this)
        val name = userPref.getString(Constants.user_key)
        if (name != "") { // name already set, send user to Frases activity
            startActivity(Intent(this, FrasesActivity::class.java))
            finish()
        }
    }

    override fun onClick(p0: View) {
        if (p0.id == R.id.store_button) {
            val name = binding.userInput.text.toString()
            if (name == "") {
                TODO("Avisar o usuário para preencher o nome")
                return
            }
            val userPref = UserPreferences(this)
            userPref.setString(Constants.user_key, name)

            startActivity(Intent(this, FrasesActivity::class.java))
            finish()
        }
    }
}