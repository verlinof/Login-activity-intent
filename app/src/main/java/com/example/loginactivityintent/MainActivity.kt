package com.example.loginactivityintent

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.view.LayoutInflater
import androidx.annotation.RequiresApi
import com.example.loginactivityintent.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding){
            val htmlTvChecbox = "By checking the box you agree to our <font color='#525BFF'>Terms</font> and <font color='#525BFF'>Conditions.</font>"

            tvChecbox.text = Html.fromHtml(htmlTvChecbox, Html.FROM_HTML_MODE_COMPACT)

            btnRegister.setOnClickListener(){
                val intent = Intent(this@MainActivity, dashboardActivity::class.java)
                intent.putExtra("EXT_USERNAME", etUsername.text.toString())
                intent.putExtra("EXT_EMAIL", etEmail.text.toString())
                intent.putExtra("EXT_PHONE", etPhone.text.toString())

                startActivity(intent)
            }
            btnLogin.setOnClickListener(){
                val intent = Intent(this@MainActivity, loginActivity::class.java)
                startActivity(intent)
            }
        }
    }
}