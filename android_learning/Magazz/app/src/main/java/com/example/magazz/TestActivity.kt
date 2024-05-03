package com.example.magazz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.magazz.databinding.ActivityTestBinding
import com.example.magazz.db.DbManager
import com.example.magazz.models.product

class TestActivity : AppCompatActivity() {
    lateinit var binding: ActivityTestBinding
    val mydbManager = DbManager(this)
    var P_list: List<product> = listOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTestBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.testPost.setOnClickListener {
        //    val tn = binding.testProductName.text.toString()
          //  val td = binding.testProductDesc.text.toString()
           // val tp = binding.testPrice.text.toString().toInt()
           // val ta = binding.testamount.text.toString().toInt()

            mydbManager.openDb()
           // mydbManager.addProduct(tn, td, tp, ta)
            mydbManager.CloseDb()
        }

        binding.testRetr.setOnClickListener {
            mydbManager.openDb()
            P_list = mydbManager.AllProducts()
            mydbManager.CloseDb()

            var id = binding.testRetrId.text.toString().toInt()
            var textt = ""

            if(P_list.count() >= id) {
                 textt = P_list.elementAt(id - 1).name
            } else textt = "wrong"


            Toast.makeText(this, textt, Toast.LENGTH_SHORT).show()
        }
    }
}