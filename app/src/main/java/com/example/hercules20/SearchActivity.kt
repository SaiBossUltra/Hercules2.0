package com.example.hercules20

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class SearchActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        val button: Button = findViewById (R.id.button3)

        button.setOnClickListener() {
            val intent = Intent(this, homeScreen::class.java)
            startActivity(intent)
        }

        val logout: Button = findViewById (R.id.logout2)

        logout.setOnClickListener() {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}