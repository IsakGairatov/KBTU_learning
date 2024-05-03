package com.example.magazz

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.magazz.Auth.Login
import com.example.magazz.Auth.Reg
import com.example.magazz.Roles.Admins.AdminIntro
import com.example.magazz.Roles.Seller.SellerIntro
import com.example.magazz.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

      //  val sharedPreferences = getSharedPreferences("CurUs", Context.MODE_PRIVATE)

       // binding.textW.text = sharedPreferences.getString("Role", "") + sharedPreferences.getString("usId", "")


        binding.mainToSignup.setOnClickListener {
            intent = Intent(this, Reg::class.java)
            startActivity(intent)
        }

        binding.mainToSignin.setOnClickListener {
            intent = Intent(this, Login::class.java)
            startActivity(intent)
        }
    }
}