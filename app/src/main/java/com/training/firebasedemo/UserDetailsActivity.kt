package com.training.firebasedemo
import android.os.Bundle
import com.google.firebase.database.*
import com.training.firebasedemo.CommonData.eMail
import com.training.firebasedemo.databinding.ActivityUserDetaislBinding


class UserDetailsActivity : CommonActivity() {


    lateinit var binding:ActivityUserDetaislBinding
    var name=""
    var phone=""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserDetaislBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar!!.hide()
        initFireBase()
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
        databaseReference.child(userId!!).addValueEventListener(object :ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                val data =snapshot.child(eMail).value.toString()
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