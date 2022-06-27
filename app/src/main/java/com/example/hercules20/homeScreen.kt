package com.example.hercules20

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class homeScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_screen)

        val logout: Button = findViewById (R.id.logout2)

        logout.setOnClickListener() {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        val search: Button = findViewById (R.id.SearchBtn)

        search.setOnClickListener() {
            val intent = Intent(this, SearchActivity::class.java)
            startActivity(intent)
        }
    }
}