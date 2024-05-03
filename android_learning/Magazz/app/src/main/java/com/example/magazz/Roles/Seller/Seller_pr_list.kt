package com.example.magazz.Roles.Seller

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.magazz.adapters.Pr_adapter
import com.example.magazz.databinding.ActivitySellerPrListBinding
import com.example.magazz.db.DbManager
import com.example.magazz.models.product

class Seller_pr_list : AppCompatActivity() {
    lateinit var binding: ActivitySellerPrListBinding
    val mydbManager = DbManager(this)
    var P_list: ArrayList<product> = arrayListOf()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySellerPrListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mydbManager.openDb()
        P_list = mydbManager.AllProducts()
        mydbManager.CloseDb()

        binding.sellerPrList0.isClickable = true
        binding.sellerPrList0.adapter = Pr_adapter(this, P_list)

        binding.sellerSearchBtn.setOnClickListener {

            var newList = P_list.filter { pr -> binding.sellerSearchTxt.text.toString() in pr.name}
            binding.sellerPrList0.adapter = Pr_adapter(this, ArrayList(newList))
        }

        binding.sellerPrList0.setOnItemClickListener{ parent, view, position, id ->

            intent = Intent(this, Seller_edit_product::class.java)
            intent.putExtra("Pid", P_list[position].id.toString())
            intent.putExtra("Pname", P_list[position].name)
            intent.putExtra("Pdesc", P_list[position].desc)
            intent.putExtra("Pprice", P_list[position].price.toString())
            intent.putExtra("Pamount", P_list[position].amount.toString())
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()

        mydbManager.openDb()
        P_list = mydbManager.AllProducts()
        mydbManager.CloseDb()

        binding.sellerPrList0.isClickable = true
        binding.sellerPrList0.adapter = Pr_adapter(this, P_list)
    }
}