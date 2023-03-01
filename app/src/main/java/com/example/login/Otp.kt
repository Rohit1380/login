package com.example.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.login.databinding.ActivityForgetBinding
import com.example.login.databinding.ActivityOtpBinding

class Otp : AppCompatActivity() {
    lateinit var binding:ActivityOtpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding=ActivityOtpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        intent?.let {
            val email=intent.getStringExtra("Email")
            binding.tvOtp.text = email
        }
        binding.btnOtp.setOnClickListener {
            if(binding.etOtp.text.toString().length<6){
                binding.etOtp.error="Enter your 6 digit OTP"
                binding.etOtp.requestFocus()
            }
            else{
                val intent=Intent(this,Newpassword::class.java)
                startActivity(intent)
            }
        }
    }
}