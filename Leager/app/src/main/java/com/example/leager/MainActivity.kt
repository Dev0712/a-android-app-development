package com.example.leager

import android.Manifest
import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var btnRegister:Button


    // ArrayList of class ItemsViewModel
    val data = mutableListOf<ItemsViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnRegister=findViewById(R.id.btnRegister)


        btnRegister.setOnClickListener {

            val intent = Intent(this@MainActivity, RegisterActivity::class.java)

            Toast.makeText(this@MainActivity, "Add Customer", Toast.LENGTH_LONG).show()



            startActivity(intent)

        }

        if(intent.getStringExtra("Name")!=null) {
            data.add(
                ItemsViewModel(
                    intent.getStringExtra("Name").toString(),
                    intent.getStringExtra("MobileNumber").toString()
                )
            )
        }

        // getting the recyclerview by its id
        val recyclerview = findViewById<RecyclerView>(R.id.recyclerview)

        // this creates a vertical layout Manager
        recyclerview.layoutManager = GridLayoutManager(this,2)


        // This will pass the ArrayList to our Adapter
        val adapter = CustomAdapter(data)

        // Setting the Adapter with the recyclerview
        recyclerview.adapter = adapter



    }

}
