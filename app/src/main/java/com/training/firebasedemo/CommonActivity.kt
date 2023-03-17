package com.training.firebasedemo

import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


open class CommonActivity : AppCompatActivity() {
    lateinit var mAuth: FirebaseAuth
    lateinit var sharedPreferences:SharedPreferences


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar!!.hide()
        sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE)

    }
    var userId: String?
        get() = sharedPreferences.getString("userId", "")
        set(userId) = sharedPreferences.edit().putString("userId", userId).apply()


    fun initFireBase() {
        mAuth = Firebase.auth
    }
}