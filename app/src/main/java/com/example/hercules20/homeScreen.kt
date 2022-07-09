package com.example.hercules20

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.hercules20.databinding.ActivityHomeScreenBinding
import com.google.firebase.auth.FirebaseAuth

class homeScreen : AppCompatActivity() {

    private lateinit var binding: ActivityHomeScreenBinding

    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()
        checkUser() //27:22

        //handle click, logout user
        binding.logout3.setOnClickListener {
            firebaseAuth.signOut()
            checkUser()
        }



























        val search: Button = findViewById (R.id.SearchBtn)
        search.setOnClickListener() {
            val intent = Intent(this, SearchActivity::class.java)
            startActivity(intent)
        }
    }

    private fun checkUser() {
        //get current user
        val firebaseUser = firebaseAuth.currentUser
        if(firebaseUser == null){
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }else{
            val email = firebaseUser.displayName
            //ser email text
            binding.emailTV.text = email
        }
    }
}