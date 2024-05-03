package com.example.magazz.Roles.Seller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.magazz.databinding.ActivityAddPrBinding
import com.example.magazz.databinding.ActivitySellerIntroBinding
import com.example.magazz.db.DbManager

class AddPr : AppCompatActivity() {
    lateinit var binding: ActivityAddPrBinding
    val mydbManager = DbManager(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddPrBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.addPAddBtn.setOnClickListener {
            var n = binding.addPName.text.toString()
            var d = binding.addPDesc.text.toString()
            var p = binding.addPPrice.text.toString().toInt()
            var a = binding.AddPAmount.text.toString().toInt()

            mydbManager.openDb()
            mydbManager.addProduct(n, d, p, a)
            mydbManager.CloseDb()

            super.onBackPressed()
        }
    }
}