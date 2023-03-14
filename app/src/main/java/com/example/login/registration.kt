package com.example.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.login.databinding.ActivityMainBinding
import com.example.login.databinding.ActivityRegistrationBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class registration : AppCompatActivity() {
    lateinit var binding: ActivityRegistrationBinding
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        auth = Firebase.auth
        binding.btn.setOnClickListener {
            if (binding.etName.text.isEmpty()) {
                binding.etName.error = "Enter your name"
            } else if (binding.etphone.text.isEmpty()) {
                binding.etphone.error = "Enter phone number"
            } else if (binding.etpassword.text.isEmpty()) {
                binding.etpassword.error = "enter password"
            } else if (binding.etconfirm.text.isEmpty()) {
                binding.etconfirm.error = "Confirm password"
            } else {
                // intent= Intent(this,MainActivity::class.java)
                //startActivity(intent)
                System.out.println("binding.etName.text.toString() ${binding.etName.text.toString()}")
                auth.createUserWithEmailAndPassword(
                    binding.etName.text.toString(),
                    binding.etpassword.text.toString()
                ).addOnSuccessListener {
                    Toast.makeText(this, "Registered successfully", Toast.LENGTH_LONG).show()
                    var intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                }.addOnFailureListener {
                    System.out.println(" in exception $it")
                    Toast.makeText(this, "Cannot registered ${it.toString()}", Toast.LENGTH_LONG)
                        .show()
                }
            }
            binding.rbtn2.setOnCheckedChangeListener { buttonview, onlychecked ->
                if (onlychecked) {
                    binding.etothers.visibility = View.VISIBLE
                } else {
                    binding.etothers.visibility = View.GONE
                }
            }
        }
    }
}