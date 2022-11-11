package com.example.teste.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.teste.*
import com.example.teste.databinding.ActivityFrasesBinding
import com.example.teste.viewModel.FrasesModel

class FrasesActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityFrasesBinding;
    private lateinit var frasesModel: FrasesModel;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        binding = ActivityFrasesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        frasesModel = ViewModelProvider(this).get(FrasesModel::class.java)
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
        frasesModel.getAPI()
    }

    override fun onClick(p0: View) {
        if (p0.id == R.id.button_gen) {
            frasesModel.getAPI()
        }
        if (p0.id == R.id.cat_icon) {
            binding.catIcon.setColorFilter(resources.getColor(R.color.yellow))
            binding.dogIcon.setColorFilter(resources.getColor(R.color.white))
            frasesModel.setMode("cat")
            frasesModel.getAPI()
        }
        if (p0.id == R.id.dog_icon) {
            binding.catIcon.setColorFilter(resources.getColor(R.color.white))
            binding.dogIcon.setColorFilter(resources.getColor(R.color.yellow))
            frasesModel.setMode("dog")
            frasesModel.getAPI()
        }
    }

    private fun setObserver() {
        frasesModel.getFrase().observe(this, Observer {
            if(it != "")
                binding.frasesText.text = it
            else
                binding.frasesText.text = "Ué?"
        })
    }
}