package com.training.firebasedemo

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth
import com.training.firebasedemo.databinding.ActivityMainBinding
import java.lang.Exception
import android.content.Intent
import android.util.Log

import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


class MainActivity : CommonActivity() {

    lateinit var binding:ActivityMainBinding
    var email=""
    var password=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initFireBase()


        binding.btnSubmit.setOnClickListener {

            email= binding.edPhone.text.toString()
            password = binding.edPassword.text.toString()

            if (email.isNotEmpty() && password.isNotEmpty()) registerNewUser(email,password) else  Toast.makeText(this,"fill Credential",Toast.LENGTH_SHORT).show()

        }

        binding.tvLogin.setOnClickListener { callLoginPage() }

    }

    private fun callLoginPage() {
        val intent=Intent(this,LoginActivity::class.java)
        startActivity(intent)
    }

    private fun registerNewUser(email: String, password: String) {
        mAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    Toast.makeText(baseContext, "Registration complete", Toast.LENGTH_SHORT).show()
                    userId = mAuth.currentUser!!.uid
                    callProfilePage()
                } else Toast.makeText(baseContext, task.exception.toString(), Toast.LENGTH_SHORT).show()

            }
    }
    private fun callProfilePage() {
        val intent =Intent(this,UserDetailsActivity::class.java)
        startActivity(intent)
    }

}