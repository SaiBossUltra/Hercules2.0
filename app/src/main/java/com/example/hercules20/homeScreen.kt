package com.example.hercules20

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.service.controls.ControlsProviderService.TAG
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat.startActivity
import com.example.hercules20.databinding.ActivityHomeScreenBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class homeScreen : AppCompatActivity() {

    private lateinit var binding: ActivityHomeScreenBinding

    private lateinit var firebaseAuth: FirebaseAuth

    @RequiresApi(Build.VERSION_CODES.R)
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
        var currentUser = firebaseAuth.currentUser

        //loadAllData(currentUser!!.uid.toString())
        val db = Firebase.firestore
        db.collection("doctors")
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    Log.d(TAG, "${document.id} => ${document.data}")

                    if(document.id == "1234"){
                        binding.Doc1TV.text = document.data.toString().subSequence(45,60)
                    }
                }
            }
            .addOnFailureListener { exception ->
                Log.w(TAG, "Error getting documents.", exception)
            }



























        val search: Button = findViewById (R.id.SearchBtn)
        search.setOnClickListener() {
            val intent = Intent(this, SearchActivity::class.java)
            startActivity(intent)
        }
    }

     fun loadAllData(userID: String) {
         val db = Firebase.firestore

         val taskList = ArrayList<TaskModel>()
        var ref = db.collection("doctors")
         ref.get()
             .addOnSuccessListener {

                 if(it.isEmpty){
                     Toast.makeText(this@homeScreen, "No Task found", Toast.LENGTH_SHORT).show()
                     return@addOnSuccessListener
                 }

                 for(doc in it){
                     val taskModel = doc.toObject(TaskModel::class.java)
                     taskList.add(taskModel)

                 }


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