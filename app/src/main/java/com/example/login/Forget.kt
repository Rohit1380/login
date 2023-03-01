package com.example.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.login.databinding.ActivityForgetBinding

class Forget : AppCompatActivity() {
    lateinit var binding: ActivityForgetBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityForgetBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.forGet.setOnClickListener {
            if (binding.etForget.text.isEmpty()) {
                binding.etForget.error = "Enter Your EMail"
                binding.etForget.requestFocus()
            } else {
                 intent = Intent(this, Otp::class.java)
                intent.putExtra("Email", binding.etForget.text.toString())
                startActivity(intent)
            }
        }
    }
}