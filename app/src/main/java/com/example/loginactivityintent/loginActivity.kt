package com.example.loginactivityintent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.loginactivityintent.databinding.ActivityLoginBinding

class loginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding){
            btnRegister.setOnClickListener(){
                val intent = Intent(this@loginActivity, MainActivity::class.java)
                startActivity(intent)
            }
        }
    }
}