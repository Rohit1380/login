package com.example.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.login.databinding.ActivityForgetBinding
import com.example.login.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btn.setOnClickListener {
            if (binding.etemail.text.isEmpty()) {
                binding.etemail.error = "Enter Email"
            } else if (binding.etpassword.text.isEmpty()) {
                binding.etpassword.error = "Enter Password"
            } else {
                var email = binding.etemail.text
                var passwrd = binding.etpassword.text
            }

        }
        binding.tvregister.setOnClickListener {
            intent = Intent(this, registration::class.java)
            startActivity(intent)
        }
        binding.forgot.setOnClickListener {
            intent = Intent(this, Forget::class.java)
            startActivity(intent)

        }
    }
}