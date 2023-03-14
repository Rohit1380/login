package com.example.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import com.example.login.databinding.ActivityForgetBinding
import com.example.login.databinding.ActivityLoginedBinding
import com.example.login.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        //if (auth.currentUser!=null){
          //  startActivity(Intent(this,ActivityLoginedBinding::class.java))
       // }

        auth = Firebase.auth
        binding.btn.setOnClickListener {
            if (binding.etemail.text.isEmpty()) {
                binding.etemail.error = "Enter Email"
            } else if (binding.etpassword.text.isEmpty()) {
                binding.etpassword.error = "Enter Password"
            } else {
             //   var email = binding.etemail.text
               // var passwrd = binding.etpassword.text
                auth.signInWithEmailAndPassword(binding.etemail.text.toString(),binding.etpassword.text.toString()).addOnSuccessListener {
                    Toast.makeText(this,"Login Sucessfully",Toast.LENGTH_LONG).show()
                }.addOnFailureListener {
                    Toast.makeText(this,"can't Login",Toast.LENGTH_LONG).show()
                }
            }

        }
        binding.tvregister.setOnClickListener {
            intent = Intent(this, registration::class.java)
            startActivity(this.intent)
        }
        binding.forgot.setOnClickListener {
            intent = Intent(this, Forget::class.java)
            startActivity(intent)

        }
    }
}