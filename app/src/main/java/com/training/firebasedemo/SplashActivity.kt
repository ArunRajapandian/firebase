package com.training.firebasedemo

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import com.training.firebasedemo.databinding.ActivitySplashBinding

class SplashActivity:CommonActivity() {

    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Handler().postDelayed({
            val i = Intent(this, RegisterActivity::class.java)
            startActivity(i)
            finish()
        }, 3000)
    }
}