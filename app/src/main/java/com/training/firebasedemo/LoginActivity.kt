package com.training.firebasedemo
import android.os.Bundle
import android.widget.Toast
import android.content.Intent
import androidx.core.view.isVisible
import com.training.firebasedemo.databinding.ActivityRegisterBinding


class LoginActivity : CommonActivity() {


    private lateinit var binding:ActivityRegisterBinding
    var email=""
    var password=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initFireBase()
        binding.tvContent.isVisible = false
        binding.tvLogin.isVisible =false

        binding.btnSubmit.setOnClickListener {

            email= binding.edPhone.text.toString()
            password = binding.edPassword.text.toString()

            if (email.isNotEmpty() && password.isNotEmpty()) loginUser(email,password) else  Toast.makeText(this," PLease fill Credential",Toast.LENGTH_SHORT).show()

        }
    }

    private fun loginUser(email: String, password: String) {
        mAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    Toast.makeText(baseContext, "Login Success", Toast.LENGTH_SHORT).show()
                    callProfile()
                    userId= mAuth.currentUser!!.uid
                } else {
                    Toast.makeText(baseContext, task.exception.toString(), Toast.LENGTH_SHORT).show()
                }
            }
    }

    private fun callProfile() {
        val intent =Intent(this,UserDetailsActivity::class.java)
        startActivity(intent)
    }
}