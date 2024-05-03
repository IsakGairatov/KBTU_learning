package com.example.magazz.adapters

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.magazz.R
import com.example.magazz.models.product

class Pr_adapter(private val context: Activity, private val arrayList: ArrayList<product>): ArrayAdapter<product>(context, R.layout.pr_item, arrayList) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflater: LayoutInflater = LayoutInflater.from(context)
        val view: View = inflater.inflate(R.layout.pr_item, null)

        val nm: TextView = view.findViewById(R.id.p_item_name)
        val pc: TextView = view.findViewById(R.id.p_item_price)

        nm.text = arrayList[position].name
        pc.text = arrayList[position].price.toString()

        return view

    }
}