package com.training.firebasedemo
import android.os.Bundle
import android.widget.Toast
import com.training.firebasedemo.databinding.ActivityRegisterBinding
import android.content.Intent
import com.training.firebasedemo.CommonData.eMail


class RegisterActivity : CommonActivity() {

    private lateinit var binding: ActivityRegisterBinding
    var email=""
    var password=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initFireBase()


        binding.btnSubmit.setOnClickListener {
            email= binding.edPhone.text.toString()
            password = binding.edPassword.text.toString()

            if (email.isNotEmpty() && password.isNotEmpty()) registerNewUser(email,password) else  Toast.makeText(this,"Please fill Credentials",Toast.LENGTH_SHORT).show()
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
                    databaseReference.child(userId!!).child(eMail).setValue(email)
                    callProfilePage()
                } else Toast.makeText(baseContext, task.exception.toString(), Toast.LENGTH_SHORT).show()

            }
    }
    private fun callProfilePage() {
        val intent =Intent(this,UserDetailsActivity::class.java)
        startActivity(intent)
    }

}