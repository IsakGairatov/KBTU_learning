package com.example.magazz.Auth

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.SharedPreferences
import android.widget.Toast


import com.example.magazz.MainActivity
import com.example.magazz.Roles.Admins.AdminIntro
import com.example.magazz.Roles.Buyer.Buyer_itro
import com.example.magazz.Roles.Buyer.ProductList
import com.example.magazz.Roles.Seller.SellerIntro
import com.example.magazz.databinding.ActivityLoginBinding
import com.example.magazz.db.DbManager

class Login : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    lateinit var sPref: SharedPreferences
    val mydbManager = DbManager(this)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.textView4.setOnClickListener {
            intent = Intent(this, Reg::class.java)
            startActivity(intent)
        }

        binding.button2.setOnClickListener {
            var bngName = binding.editTextTextEmailAddress2.text.toString()
            var bngPass = binding.editTextTextPassword2.text.toString()

            mydbManager.openDb()
            var usData = mydbManager.signIn(bngName, bngPass)
            mydbManager.CloseDb()

            if(usData.first == "False") {
                Toast.makeText(this, "Wrong password", Toast.LENGTH_SHORT).show()
            } else {
                sPref = getSharedPreferences("CurUs", Context.MODE_PRIVATE)
                val editor = sPref.edit()

                editor.apply {
                   putString("Role", usData.first)
                   putString("usId", usData.second.toString())

                }.apply()


                if(usData.first == "Buyer") {
                    intent = Intent(this, Buyer_itro::class.java)
                    startActivity(intent)
                }
                else if(usData.first == "Seller") {
                    intent = Intent(this, SellerIntro::class.java)
                    startActivity(intent)
                }
                else if(usData.first == "Admin") {
                    intent = Intent(this, AdminIntro::class.java)
                    startActivity(intent)
                }
            }



        }
    }
}