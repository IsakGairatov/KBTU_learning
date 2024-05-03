package com.example.magazz.Roles.Buyer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.magazz.databinding.ActivityBuyerItroBinding

class Buyer_itro : AppCompatActivity() {
    lateinit var binding: ActivityBuyerItroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBuyerItroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buyerToProducts.setOnClickListener {
            intent = Intent(this, ProductList::class.java)
            startActivity(intent)
        }

        binding.buyerToPurchases.setOnClickListener {
            intent = Intent(this, Buyer_purchases::class.java)
            startActivity(intent)
        }
    }
}