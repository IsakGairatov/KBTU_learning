package com.example.magazz.Roles.Admins

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.magazz.databinding.ActivityAdminEditUserBinding
import com.example.magazz.databinding.ActivityLoginBinding
import com.example.magazz.databinding.ActivitySellerEditProductBinding
import com.example.magazz.db.DbManager

class Admin_edit_user : AppCompatActivity() {
    lateinit var binding: ActivityAdminEditUserBinding
    val mydbManager = DbManager(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAdminEditUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.AdminUserEditEmaill.setText(intent.getStringExtra("Ue"))
        binding.currentRole.setText(intent.getStringExtra("Ur"))

        binding.AdminUserEditEmaill.setOnClickListener {
            if(binding.deleteUserBtn.visibility == View.GONE) binding.deleteUserBtn.visibility = View.VISIBLE
            else binding.deleteUserBtn.visibility = View.GONE
        }

        binding.setRoleA.setOnClickListener {
            binding.currentRole.setText("Admin")
        }

        binding.setRoleB.setOnClickListener {
            binding.currentRole.setText("Buyer")
        }

        binding.setRoleS.setOnClickListener {
            binding.currentRole.setText("Seller")
        }

        binding.userEditBack.setOnClickListener {
            super.onBackPressed()
        }

        binding.changeRole.setOnClickListener {
            val id = intent.getStringExtra("Uid").toString().toInt()
            mydbManager.openDb()
            mydbManager.ChangeRole(id, binding.currentRole.text.toString())
            mydbManager.CloseDb()

            super.onBackPressed()
        }

        binding.deleteUserBtn.setOnClickListener {
            val id = intent.getStringExtra("Uid").toString().toInt()
            mydbManager.openDb()
            mydbManager.deleteUser(id)
            mydbManager.CloseDb()
            super.onBackPressed()
        }
    }


}