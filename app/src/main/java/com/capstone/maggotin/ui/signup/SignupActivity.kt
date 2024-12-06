package com.capstone.maggotin.ui.signup

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.capstone.maggotin.databinding.ActivitySignupBinding
import com.capstone.maggotin.ui.login.LoginActivity

class SignupActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignupBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        // Gunakan binding untuk tombol signup
        binding.btnSignup.setOnClickListener {
            val password = binding.passwordEditText.text
            val confirmPassword = binding.passworConfirmdEditText.text

            if (checkPasswordMatch(password, confirmPassword)) {
                // Pindah ke LoginActivity hanya jika password cocok
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
            }
        }
    }

    private fun checkPasswordMatch(password: CharSequence?, confirmPassword: CharSequence?): Boolean {
        val passwordText = password?.toString()?.trim()
        val confirmPasswordText = confirmPassword?.toString()?.trim()

        return when {
            passwordText.isNullOrEmpty() || confirmPasswordText.isNullOrEmpty() -> {
                Toast.makeText(this, "Password fields cannot be empty", Toast.LENGTH_SHORT).show()
                false
            }
            passwordText == confirmPasswordText -> {
                Toast.makeText(this, "Passwords match!", Toast.LENGTH_SHORT).show()
                true
            }
            else -> {
                Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show()
                false
            }
        }
    }
}
