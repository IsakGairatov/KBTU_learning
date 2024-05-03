package com.example.magazz.Roles.Buyer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.magazz.Roles.Seller.Seller_edit_product
import com.example.magazz.adapters.Pr_adapter
import com.example.magazz.databinding.ActivityProductListBinding
import com.example.magazz.db.DbManager
import com.example.magazz.models.product

class ProductList : AppCompatActivity() {
    lateinit var binding: ActivityProductListBinding

    val mydbManager = DbManager(this)
    var P_list: ArrayList<product> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mydbManager.openDb()
        P_list = mydbManager.AllProducts()
        mydbManager.CloseDb()

        binding.buyerPrList.isClickable = true
        binding.buyerPrList.adapter = Pr_adapter(this, P_list)

        binding.buyerSearchBtn.setOnClickListener {

            var newList = P_list.filter { pr -> binding.buyerSearchTxt.text.toString() in pr.name}
            binding.buyerPrList.adapter = Pr_adapter(this, ArrayList(newList))
        }

        binding.buyerPrList.setOnItemClickListener{ parent, view, position, id ->

            intent = Intent(this, Product_detai::class.java)
            intent.putExtra("Pid", P_list[position].id.toString())
            intent.putExtra("Pname", P_list[position].name)
            intent.putExtra("Pdesc", P_list[position].desc)
            intent.putExtra("Pprice", P_list[position].price.toString())
            intent.putExtra("Pamount", P_list[position].amount.toString())
            startActivity(intent)
        }
    }
}