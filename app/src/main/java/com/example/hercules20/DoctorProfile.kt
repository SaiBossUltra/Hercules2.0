package com.example.hercules20

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.hercules20.databinding.ActivityDoctorProfileBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class DoctorProfile : AppCompatActivity() {

    private lateinit var binding : ActivityDoctorProfileBinding
    private lateinit var database : DatabaseReference


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDoctorProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        readData("Sai")


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

    private fun readData(docName: String) {
        database = FirebaseDatabase.getInstance().getReference("Doctor")
        database.child(docName).get().addOnSuccessListener {

            if(it.exists()){

                val name = it.child("fullName").value
                val specialty = it.child("special").value
                val country = it.child("State").value
                val rating = it.child("rating").value
                val space = " "
                Toast.makeText(this, "Succefully read data", Toast.LENGTH_SHORT).show()

                binding.DocNameTv.text = name.toString()
                binding.SpecialTv.text = specialty.toString()
                binding.LocationTv.text = country.toString()
                binding.OtherTv.text = rating.toString()





            }else{
                Toast.makeText(this, "Doc dont exist buddy", Toast.LENGTH_SHORT).show()
            }

        }.addOnFailureListener{
            Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show()
        }
    }
}