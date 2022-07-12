package com.example.hercules20

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.hercules20.databinding.ActivityMainBinding
import com.example.hercules20.databinding.ActivityResultsBinding
import java.util.jar.Attributes

class ResultsActivity : AppCompatActivity() {
    private lateinit var binding : ActivityResultsBinding
    private lateinit var  userArrayList : ArrayList<User>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val image = intArrayOf(
            R.drawable.hygieia_logo
        )
        val name = arrayOf(
            "Sai",
            "Pranav",
            "Jeff",
            "Michelle",
            "Skye",
            "Alex",
            "Sophia",
            "Bob",
            "Dan"

        )
        val location = arrayOf(
            "blank",
            "blank",
            "blank",
            "blank",
            "blank",
            "blank",
            "blank",
            "blank",
            "blank"
        )
        val phoneNo = arrayOf(
            "9812318967","8740165879","4292345311","3521323533","1235562322","73423594134","9850892400","6572390042","5326801370","527794242"
        )
        val rating = arrayOf(
            "4.8/5", "4.8/5", "3.5/5", "4.2/5", "2.3/5", "4.5/5", "3.4/5", "3.8/5","4.7/5"
        )
        val special = arrayOf(
            "Dermatologist","Optometrist","Surgeon","Pediatrition","Chiropractor","Pediatrition","Physicians", "Neurologist", "Cardiologist"
        )
        val email = arrayOf(
            "saivallabha@gmail.com","pvudumula@gmail.com","jscott@gmail.com","milee@gmail.com","skyryder@gmail.com","alexjames@gmail.com","sstyles@gmail.com", "bdaniel@gmail.com", "dlow@gmail.com"
        )

        userArrayList=ArrayList()
        for(i in name.indices){
            val user = User(name[i],location[i],phoneNo[i],rating[i],email[i],special[i],image[0])
            userArrayList.add(user)
        }
        binding.userview.isClickable = true
        binding.userview.adapter = Adapter(this,userArrayList)
        binding.userview.setOnItemClickListener { parent, view, position, id ->
            val name = name[position]
            val phoneNo = phoneNo[position]
            val rating = rating[position]
            val email = email[position]
            val special = special[position]
            val location = location[position]
            val imageId= image[0]

            val i = Intent(this, DoctorProfile::class.java)
            i.putExtra("name", name)
            i.putExtra("phoneNo", phoneNo)
            i.putExtra("rating", rating)
            i.putExtra("email", email)
            i.putExtra("special", special)
            i.putExtra("location", location)
            i.putExtra("imageId", imageId)
            startActivity(i)

        }
    }
}