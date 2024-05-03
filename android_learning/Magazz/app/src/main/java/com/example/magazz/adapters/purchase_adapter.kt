package com.example.magazz.adapters

import android.annotation.SuppressLint
import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.magazz.R
import com.example.magazz.models.Purchases
import com.example.magazz.models.User2

class purchase_adapter (private val context: Activity, private val arrayList: ArrayList<Purchases>) : ArrayAdapter<Purchases>(context, R.layout.purchase_item, arrayList) {

    @SuppressLint("MissingInflatedId")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflater: LayoutInflater = LayoutInflater.from(context)
        val view: View = inflater.inflate(R.layout.purchase_item, null)

        val Buyer_id: TextView = view.findViewById(R.id.pch_us_name)
        val P_id: TextView = view.findViewById(R.id.pch_pr_name)
        val ad: TextView = view.findViewById(R.id.pch_address)
        val ph: TextView = view.findViewById(R.id.pch_phone)

        Buyer_id.text = arrayList[position].buyer_id.toString()
        P_id.text = arrayList[position].product_id.toString()
        ad.text = arrayList[position].address
        ph.text = arrayList[position].phoneNumber

        return view

    }
}