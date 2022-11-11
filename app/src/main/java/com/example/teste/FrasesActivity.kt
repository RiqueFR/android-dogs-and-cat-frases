package com.example.teste

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.teste.databinding.ActivityFrasesBinding
import com.example.teste.databinding.ActivityMainBinding

class FrasesActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityFrasesBinding;
    private var mode : String = "cat";
    private lateinit var cat_list : FrasesCat;
    private val dog_list = FrasesDog();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        binding = ActivityFrasesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        cat_list = ViewModelProvider(this).get(FrasesCat::class.java)
        setObserver()

        binding.catIcon.setOnClickListener(this)
        binding.dogIcon.setOnClickListener(this)
        binding.buttonGen.setOnClickListener(this)

        val userPref = UserPreferences(this)
        val name : String= userPref.getString(Constants.user_key)
        if (name != "") {
            val greet = binding.greetingsText.text
            binding.greetingsText.text = greet.toString()+ " " + name
        }
        // gen cat frase
        cat_list.getAPI()
        //binding.frasesText.text = frase
    }

    override fun onClick(p0: View) {
        if (p0.id == R.id.button_gen) {
            if (mode == "cat") {
                cat_list.getAPI()
                //binding.frasesText.text = frase
            } else {
                val frase = dog_list.getFrase()
                binding.frasesText.text = frase
            }
            // gen new frase
        }
        if (p0.id == R.id.cat_icon) {
            mode = "cat"
            binding.catIcon.setColorFilter(resources.getColor(R.color.yellow))
            binding.dogIcon.setColorFilter(resources.getColor(R.color.white))
            cat_list.getAPI()
            //binding.frasesText.text = frase
            // change to cat frases
        }
        if (p0.id == R.id.dog_icon) {
            mode = "dog"
            binding.catIcon.setColorFilter(resources.getColor(R.color.white))
            binding.dogIcon.setColorFilter(resources.getColor(R.color.yellow))
            val frase = dog_list.getFrase()
            binding.frasesText.text = frase
            // change to dog frases
        }
    }

    private fun setObserver() {
        cat_list.getFrase().observe(this, Observer {
            if(it != "")
                binding.frasesText.text = it
            else
                binding.frasesText.text = "Ué?"
        })
    }
}