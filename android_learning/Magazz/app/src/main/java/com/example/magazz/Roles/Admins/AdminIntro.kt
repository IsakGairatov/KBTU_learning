package com.example.magazz.Roles.Admins

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.magazz.Roles.Seller.AddPr
import com.example.magazz.Roles.Seller.Seller_pr_list
import com.example.magazz.databinding.ActivityAdminIntroBinding
import com.example.magazz.databinding.ActivitySellerEditProductBinding

class AdminIntro : AppCompatActivity() {
    lateinit var binding: ActivityAdminIntroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAdminIntroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.adminToSellerList.setOnClickListener {
            intent = Intent(this, Seller_pr_list::class.java)
            startActivity(intent)
        }

        binding.adminToAddPr.setOnClickListener {
            intent = Intent(this, AddPr::class.java)
            startActivity(intent)
        }

        binding.adminToUsers.setOnClickListener {
            intent = Intent(this, Admin_userList::class.java)
            startActivity(intent)
        }
    }
}