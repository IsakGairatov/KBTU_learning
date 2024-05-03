package com.example.magazz.Auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import com.example.magazz.Roles.Admins.AdminIntro
import com.example.magazz.databinding.ActivityRegBinding
import com.example.magazz.db.DbManager

class Reg : AppCompatActivity() {
    lateinit var binding: ActivityRegBinding
    val mydbManager = DbManager(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.textView2.setOnClickListener {
            intent = Intent(this, Login::class.java)
            startActivity(intent)
        }

        binding.button.setOnClickListener {
            var bngName = binding.editTextTextEmailAddress.text.toString()
            var bngPass = binding.editTextTextPassword.text.toString()
            if(bngName == "MagazBoss89" &&  bngPass == "bonbon12")
            {
                intent = Intent(this, AdminIntro::class.java)
                startActivity(intent)

            } else {

                fun CharSequence?.isValidEmail() = !isNullOrEmpty() && Patterns.EMAIL_ADDRESS.matcher(this).matches()

                if(bngName.isValidEmail()) {
                    mydbManager.openDb()
                    val res = mydbManager.signUp(bngName, bngPass)
                    mydbManager.CloseDb()

                    if (res) {
                        super.onBackPressed()
                    } else {
                        Toast.makeText(this, "There is already this email", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    Toast.makeText(this, "It's not valid email", Toast.LENGTH_SHORT).show()
                }

            }
        }
    }
}