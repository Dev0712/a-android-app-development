package com.example.babaro.Activity

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.app.Person
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.babaro.R
import com.example.babaro.adapter.DashboardRecyclerAdapter


class MainActivity() : AppCompatActivity() {

    lateinit var callbtn: Button
    lateinit var btnRegister: Button
    lateinit var phoneNo:String
    lateinit var recyclerDashboard:RecyclerView
    lateinit var layoutManager :RecyclerView.LayoutManager

    val customerList = arrayListOf(
        "ram",
        "sh",
        "gggj",
        "ngvhvjl",
        "ngjkjesjk,",
        "gfudshgjk",
        "kshhdsjvj",
        "ldvbjkadsbvbj",
        "klsdnbas",
        "sdbfjs"
    )

    lateinit var recyclerAdapter: DashboardRecyclerAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerDashboard = findViewById(R.id.recyclerDashboard)
        layoutManager = LinearLayoutManager(this)
        recyclerAdapter = DashboardRecyclerAdapter(this,customerList)

        btnRegister.setOnClickListener()
        {
            startActivity(Intent(this@MainActivity, RegisterActivity::class.java))

        }


        if (ContextCompat.checkSelfPermission(
                this@MainActivity,
                Manifest.permission.CALL_PHONE
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this@MainActivity,
                arrayOf(Manifest.permission.CALL_PHONE),
                PERMISSION_CODE
            )
        }
        callbtn.setOnClickListener(View.OnClickListener {
            val i = Intent(Intent.ACTION_CALL)
            i.data = Uri.parse("tel:$phoneNo")
            startActivity(i)
        })
    }

    companion object {
        var PERMISSION_CODE = 100


    }
}
