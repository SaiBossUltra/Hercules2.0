package com.example.hercules20

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class DoctorProfile : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_doctor_profile)

        val logout: Button = findViewById (R.id.logout3)

        logout.setOnClickListener() {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        val home: Button = findViewById (R.id.HomeBtn)

        home.setOnClickListener() {
            val intent = Intent(this, homeScreen::class.java)
            startActivity(intent)
        }
    }
}