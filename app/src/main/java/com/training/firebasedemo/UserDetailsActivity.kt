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
import com.training.firebasedemo.databinding.ActivityUserDetaislBinding


class UserDetailsActivity : AppCompatActivity() {

    private lateinit var mAuth: FirebaseAuth

    lateinit var binding:ActivityUserDetaislBinding
    var email=""
    var password=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserDetaislBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mAuth = Firebase.auth





    }


}