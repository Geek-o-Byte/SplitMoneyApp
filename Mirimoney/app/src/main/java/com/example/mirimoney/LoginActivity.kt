package com.example.mirimoney

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class LoginActivity : AppCompatActivity() {

    val auth = FirebaseAuth.getInstance()
    val db: DatabaseReference = Firebase.database.reference
    val users = db.child("Users")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val email = findViewById<TextView>(R.id.email)
        val password = findViewById<TextView>(R.id.password)
//        val submit = findViewById<TextView>(R.id.register_submit)


        fun createUser(email: String, password: String){
            auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { task ->
                    if(task.isSuccessful){
                        db.child("users").child("userId").child("name").setValue("Max")
                        var intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
                    }
                    else{

                    }
                }
        }

//        submit.setOnClickListener{
//            if(email.text.trim().toString().isNotEmpty() || password.text.trim().toString().isNotEmpty()){
//                createUser(email.text.trim().toString(), password.text.trim().toString())
//            }
//            else{
//                Toast.makeText(this, "Input requiered", Toast.LENGTH_LONG).show()
//            }
//        }

    }

    override fun onStart() {
        super.onStart()
        val user = auth.currentUser
        if (user != null){
            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}
