package com.example.mirimoney

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.inputmethod.InputBinding
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity(){

    lateinit var bottomNav: BottomNavigationView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val user = Firebase.auth.currentUser

        val username = user?.uid



        setContentView(R.layout.activity_main)
        replaceFragment(Home())
        bottomNav = findViewById<BottomNavigationView>(R.id.bottomNav)
        bottomNav.setOnItemSelectedListener {
            when(it.itemId){
                R.id.home -> {
                    replaceFragment(Home())
                    true
                }
                R.id.payments -> {
                    replaceFragment(Payments())
                    true
                }
                R.id.me -> {
                    replaceFragment(Me())
                    true
                }
                else -> {
                    true
                }
            }
        }

    }


//    override fun onStart() {
//        super.onStart()
//        val user = auth.currentUser
//        if (user != null){
//            var intent = Intent(this, LoginActivity::class.java)
//            startActivity(intent)
//        }
//    }

    private fun replaceFragment(fragment: Fragment){
        val fragmentManager = supportFragmentManager
        val bundle = Bundle()
        bundle.putString("username", username)
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout,fragment)
        fragmentTransaction.commit()
    }
}