package com.example.magazz.Roles.Buyer

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.magazz.adapters.Pr_adapter
import com.example.magazz.adapters.comment_adapter
import com.example.magazz.databinding.ActivityProductCommentsBinding
import com.example.magazz.db.DbManager

class Product_Comments : AppCompatActivity() {
    lateinit var binding: ActivityProductCommentsBinding
    val mydbManager = DbManager(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductCommentsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val p_id = intent.getStringExtra("Pid").toString().toInt()

        val sharedPreferences = getSharedPreferences("CurUs", Context.MODE_PRIVATE)

        val B_id = sharedPreferences.getString("usId", "0").toString().toInt()


        mydbManager.openDb()
        var c_list = mydbManager.ProductComments(p_id)
        mydbManager.CloseDb()

        binding.commentList.isClickable = true
        binding.commentList.adapter = comment_adapter(this, c_list)

        binding.commentBtn.setOnClickListener {
            mydbManager.openDb()
            mydbManager.CommentProduct(B_id, p_id, binding.commentTxt.text.toString())
            var c_list = mydbManager.ProductComments(p_id)
            mydbManager.CloseDb()
            binding.commentList.adapter = comment_adapter(this, c_list)
            binding.commentTxt.text.clear()
        }
    }

}