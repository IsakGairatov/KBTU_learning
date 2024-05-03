package com.example.magazz.Roles.Buyer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.magazz.databinding.ActivityProductDetaiBinding
import com.example.magazz.databinding.CommentItemBinding
import com.example.magazz.models.product

class Product_detai : AppCompatActivity() {
    lateinit var binding: ActivityProductDetaiBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductDetaiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val id = intent.getStringExtra("Pid").toString()
        binding.prDName.text = intent.getStringExtra("Pname")
        binding.prDDesc.text = intent.getStringExtra("Pdesc")
        binding.bAmount.text = intent.getStringExtra("Pamount")
        binding.bPrice.text = intent.getStringExtra("Pprice")

        binding.buyBtn.setOnClickListener {
            intent = Intent(this, Product_purchase::class.java)
            intent.putExtra("Pid", id)
            startActivity(intent)
        }

        binding.commentsBtn.setOnClickListener {
            intent = Intent(this, Product_Comments::class.java)
            intent.putExtra("Pid", id)
            startActivity(intent)
        }
    }


}