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
import com.google.firebase.database.*
import com.google.firebase.ktx.Firebase
import com.training.firebasedemo.CommonData.firebaseRoute
import com.training.firebasedemo.databinding.ActivityUserDetaislBinding


class UserDetailsActivity : CommonActivity() {


    lateinit var binding:ActivityUserDetaislBinding
    var name=""
    var phone=""
    lateinit var databaseReference: DatabaseReference
    lateinit var listener: ValueEventListener


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserDetaislBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar!!.hide()
        databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl(firebaseRoute)

        getDbValues()

        binding.btnDone.setOnClickListener {
            if (binding.edName.text.isNotEmpty() && binding.edPhone.text.isNotEmpty()){
                name =binding.edName.text.toString()
                phone =binding.edPhone.text.toString()
                addDatatoFirebase(name, phone)
            }


        }



    }

    private fun getDbValues() {
        databaseReference.addValueEventListener(object :ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                val data =snapshot.child("userName").value.toString()
                binding.edName.setText(data)
            }

            override fun onCancelled(error: DatabaseError) {
            }

        })
    }

    private fun addDatatoFirebase(nameData: String, phoneData: String) {
         databaseReference.child(userId!!).child("userName").setValue(nameData)
         databaseReference.child(userId!!).child("userPhone").setValue(phoneData)


    }


}