package com.example.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.login.databinding.ActivityNewpasswordBinding

class Newpassword : AppCompatActivity() {
    lateinit var binding: ActivityNewpasswordBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewpasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSave.setOnClickListener {
            if (binding.etpassword.text.isEmpty()) {
                binding.etpassword.error = "Enter your new password"
                binding.etpassword.requestFocus()
            } else if (binding.etconfirm.text.isEmpty()) {
                binding.etconfirm.error = "Confirm your password"
                binding.etconfirm.requestFocus()
            } else {
                var intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                Toast.makeText(this, "Password changed successfully", Toast.LENGTH_SHORT).show()

            }
        }
    }
}