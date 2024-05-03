package com.example.magazz.adapters

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.magazz.R
import com.example.magazz.models.comment

class comment_adapter(private val context: Activity, private val arrayList: ArrayList<comment>): ArrayAdapter<comment>(context, R.layout.comment_item, arrayList) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflater: LayoutInflater = LayoutInflater.from(context)
        val view: View = inflater.inflate(R.layout.comment_item, null)

        val com: TextView = view.findViewById(R.id.comment_item_comment)

        com.text = arrayList[position].Comment


        return view

    }
}
