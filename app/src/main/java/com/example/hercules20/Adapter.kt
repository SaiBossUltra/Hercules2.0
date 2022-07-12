package com.example.hercules20

import android.app.Activity
import android.widget.ArrayAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

class Adapter(private val context: Activity, private val arrayList: ArrayList<User>) :
    ArrayAdapter<User>(context, R.layout.list_item,arrayList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View{
        val inflater:LayoutInflater = LayoutInflater.from(context)
        val view:View = inflater.inflate(R.layout.list_item, null)

        val imageView: ImageView = view.findViewById(R.id.profile_pic)
        val username: TextView = view.findViewById(R.id.personName)
        val special: TextView = view.findViewById(R.id.special)
        val rating: TextView = view.findViewById(R.id.rating)

        imageView.setImageResource(arrayList[position].imageID)
        username.text = arrayList[position].name
        special.text = arrayList[position].special
        rating.text = arrayList[position].rating

        return view
    }
}