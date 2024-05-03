package com.example.magazz.Roles.Seller

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.magazz.databinding.ActivitySellerIntroBinding

class SellerIntro : AppCompatActivity() {
    lateinit var binding: ActivitySellerIntroBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySellerIntroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.sellerToAddP.setOnClickListener {
            intent = Intent(this, AddPr::class.java)
            startActivity(intent)
        }

        binding.sellerToListOfP.setOnClickListener {
            intent = Intent(this, Seller_pr_list::class.java)
            startActivity(intent)
        }
    }
}