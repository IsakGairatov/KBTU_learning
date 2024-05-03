package com.example.magazz.Roles.Buyer

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import com.example.magazz.databinding.ActivityProductPurchaseBinding
import com.example.magazz.db.DbManager

class Product_purchase : AppCompatActivity() {
    lateinit var binding: ActivityProductPurchaseBinding
    val mydbManager = DbManager(this)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductPurchaseBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sharedPreferences = getSharedPreferences("CurUs", Context.MODE_PRIVATE)

        val B_id = sharedPreferences.getString("usId", "0").toString().toInt()
        val P_id = intent.getStringExtra("Pid").toString().toInt()
        fun CharSequence?.isValidPhone() = !isNullOrEmpty() && Patterns.PHONE.matcher(this).matches()


        binding.buyFinal.setOnClickListener {
                if(binding.editTextPhone.text.toString().isValidPhone()) {
                     mydbManager.openDb()
                     mydbManager.makePurchase(B_id, P_id, binding.editTextTextPostalAddress.text.toString(), binding.editTextPhone.text.toString())
                     mydbManager.CloseDb()
                     onBackPressed()
                } else Toast.makeText(this, "this is not phone number", Toast.LENGTH_SHORT).show()
            }


    }
}