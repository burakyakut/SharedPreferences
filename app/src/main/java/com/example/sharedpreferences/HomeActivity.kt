package com.example.sharedpreferences

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sharedpreferences.databinding.ActivityHomeBinding
import com.example.sharedpreferences.databinding.ActivityMainBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    private lateinit var sharedPref: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sharedPref=this.getSharedPreferences("com.example.sharedpreferences", MODE_PRIVATE)
        val saveName=sharedPref.getString("name","")
        val saveEmail=sharedPref.getString("email","")

        binding.tvName.text=saveName
        binding.tvEmail.text=saveEmail

        binding.btnLogout.setOnClickListener {
            sharedPref.edit().remove("name").apply()
            sharedPref.edit().remove("email").apply()
            val intent=Intent(this,MainActivity::class.java)
            startActivity(intent)
            //intent mainactivity

        }


    }
}