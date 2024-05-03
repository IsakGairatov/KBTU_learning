package com.example.magazz.adapters

import android.annotation.SuppressLint
import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.magazz.R
import com.example.magazz.models.User
import com.example.magazz.models.User2

class User_adapter(private val context: Activity, private val arrayList: ArrayList<User2>) : ArrayAdapter<User2>(context, R.layout.user_item, arrayList) {

    @SuppressLint("MissingInflatedId")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflater: LayoutInflater = LayoutInflater.from(context)
        val view: View = inflater.inflate(R.layout.user_item, null)

        val email: TextView = view.findViewById(R.id.item_email)

        email.text = arrayList[position].usname

        return view

    }
}
