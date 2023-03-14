package com.example.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.login.databinding.ActivityLoginedBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginedActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginedBinding
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityLoginedBinding.inflate(layoutInflater)
        setContentView(binding.root)
        auth= Firebase.auth
        binding.btnlogout.setOnClickListener {
            auth.signOut()
              startActivity(Intent(this,MainActivity::class.java))
            finish()
        }

    }
}