package com.example.magazz.Roles.Seller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.example.magazz.databinding.ActivitySellerEditProductBinding
import com.example.magazz.db.DbManager

class Seller_edit_product : AppCompatActivity() {
    lateinit var binding: ActivitySellerEditProductBinding
    val mydbManager = DbManager(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySellerEditProductBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val id = intent.getStringExtra("Pid").toString().toInt()
        binding.updateName.setText(intent.getStringExtra("Pname"))
        binding.updateDesc.setText(intent.getStringExtra("Pdesc"))
        binding.updatePrice.setText(intent.getStringExtra("Pprice").toString(), TextView.BufferType.EDITABLE)
        binding.UpdateAmount.setText(intent.getStringExtra("Pamount").toString(), TextView.BufferType.EDITABLE)

        binding.sellerrUpdate.setOnClickListener {
            mydbManager.openDb()
            mydbManager.UpdateProduct(id, binding.updateName.text.toString(), binding.updateDesc.text.toString(),
            binding.updatePrice.text.toString().toInt(), binding.UpdateAmount.text.toString().toInt())
            mydbManager.CloseDb()

            super.onBackPressed()
        }

        binding.sellerDeletePr.setOnClickListener {
            mydbManager.openDb()
            mydbManager.deleteProduct(id)
            mydbManager.CloseDb()
            super.onBackPressed()
        }

        binding.sellerEditBack.setOnClickListener {
            super.onBackPressed()
        }
    }
}