package com.example.magazz.Roles.Buyer

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.magazz.adapters.Pr_adapter
import com.example.magazz.adapters.purchase_adapter
import com.example.magazz.databinding.ActivityBuyerPurchasesBinding
import com.example.magazz.db.DbManager

class Buyer_purchases : AppCompatActivity() {
    lateinit var binding: ActivityBuyerPurchasesBinding
    val mydbManager = DbManager(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBuyerPurchasesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sharedPreferences = getSharedPreferences("CurUs", Context.MODE_PRIVATE)

        val id = sharedPreferences.getString("usId", "0").toString().toInt()

        mydbManager.openDb()
        var myPurchs = mydbManager.MyPurchases(id)
        mydbManager.CloseDb()


        binding.myPurchList.isClickable = true
        binding.myPurchList.adapter = purchase_adapter(this, myPurchs)
    }
}