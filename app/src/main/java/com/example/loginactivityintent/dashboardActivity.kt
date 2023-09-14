package com.example.loginactivityintent

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.ScriptGroup.Binding
import android.text.Html
import androidx.annotation.RequiresApi
import com.example.loginactivityintent.databinding.ActivityDashboardBinding

class dashboardActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDashboardBinding
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dataIntent = intent

        val username = dataIntent.getStringExtra("EXT_USERNAME") ?: "Username"
        val email = dataIntent.getStringExtra("EXT_EMAIL") ?: "Email"
        val phone = dataIntent.getStringExtra("EXT_PHONE") ?: "Phone"

        with(binding){
            val htmlEmail = "Your <font color='#525BFF'>$email</font> has been activated"
            val htmlPhone = "Your <font color='#525BFF'>$phone</font> has been activated"

            tvUsernameData.text = username
            tvEmail.text = Html.fromHtml(htmlEmail, Html.FROM_HTML_MODE_COMPACT)
            tvPhone.text = Html.fromHtml(htmlPhone, Html.FROM_HTML_MODE_COMPACT)

            btnBack.setOnClickListener(){
                val intent = Intent(this@dashboardActivity, loginActivity::class.java)
                startActivity(intent)
            }
        }
    }
}