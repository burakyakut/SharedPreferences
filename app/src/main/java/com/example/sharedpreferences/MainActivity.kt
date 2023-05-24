package com.example.sharedpreferences

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import com.example.sharedpreferences.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var sharedPref: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sharedPref=this.getSharedPreferences("com.example.sharedpreferences", MODE_PRIVATE)

        val saveName=sharedPref.getString("name","")
        val saveEmail=sharedPref.getString("email","")
        if (saveName!="" && saveEmail!="") {
                val intent=Intent(this,HomeActivity::class.java)
                startActivity(intent)
        }



            binding.btnLogin.setOnClickListener {
                val name=binding.etName.text.toString()
                val email=binding.etEmail.text.toString()

                if (name.isNotEmpty() && email.isNotEmpty()){
                    sharedPref.edit().putString("name",name).apply()
                    sharedPref.edit().putString("email",email).apply()
                    val intent= Intent(this,HomeActivity::class.java)
                    startActivity(intent)
                }
            }



    }
}