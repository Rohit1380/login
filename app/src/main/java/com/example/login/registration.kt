package com.example.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.login.databinding.ActivityMainBinding
import com.example.login.databinding.ActivityRegistrationBinding

class registration : AppCompatActivity() {
    lateinit var binding: ActivityRegistrationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btn.setOnClickListener {
            if (binding.etName.text.isEmpty()) {
                binding.etName.error = "Enter your name"
            } else if (binding.etphone.text.isEmpty()) {
                binding.etphone.error = "Enter phone number"
            } else if (binding.etpassword.text.isEmpty()) {
                binding.etpassword.error = "enter password"
            } else if (binding.etconfirm.text.isEmpty()) {
                binding.etconfirm.error = "Confirm password"
            }
            else{
                intent= Intent(this,MainActivity::class.java)
                startActivity(intent)
            }
        }
        binding.rbtn2.setOnCheckedChangeListener { buttonview,onlychecked ->
            if (onlychecked) {
                binding.etothers.visibility = View.VISIBLE
            } else {
                binding.etothers.visibility = View.GONE
            }
        }
    }
}