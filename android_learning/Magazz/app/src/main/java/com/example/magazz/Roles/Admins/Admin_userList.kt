package com.example.magazz.Roles.Admins

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.magazz.Roles.Seller.Seller_edit_product
import com.example.magazz.adapters.Pr_adapter
import com.example.magazz.adapters.User_adapter
import com.example.magazz.databinding.ActivityAdminIntroBinding
import com.example.magazz.databinding.ActivityAdminUserListBinding
import com.example.magazz.db.DbManager

class Admin_userList : AppCompatActivity() {
    lateinit var binding: ActivityAdminUserListBinding
    val mydbManager = DbManager(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAdminUserListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mydbManager.openDb()
        var Us_list = mydbManager.AllUsers()
        mydbManager.CloseDb()

        binding.adminUserList0.isClickable = true
        binding.adminUserList0.adapter = User_adapter(this, Us_list)

        binding.sellerSearchBtn.setOnClickListener {

            var newList = Us_list.filter { us -> binding.adminUserSearchText.text.toString() in us.usname}
            binding.adminUserList0.adapter = User_adapter(this, ArrayList(newList))
        }

        binding.adminUserList0.setOnItemClickListener{ parent, view, position, id ->

            intent = Intent(this, Admin_edit_user::class.java)
            intent.putExtra("Uid", Us_list[position].id.toString())
            intent.putExtra("Ue", Us_list[position].usname)
            intent.putExtra("Ur", Us_list[position].Role)

            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()

        mydbManager.openDb()
        var Us_list = mydbManager.AllUsers()
        mydbManager.CloseDb()

        binding.adminUserList0.isClickable = true
        binding.adminUserList0.adapter = User_adapter(this, Us_list)

    }
}