package com.example.smp.Activity

import android.content.Context
import android.content.Intent
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.room.Room
import com.example.smp.R
import com.example.smp.database.PersonDatabase
import com.example.smp.database.PersonEntity

class RegisterActivity : AppCompatActivity() {

    lateinit var etPersonName: EditText
    lateinit var etPersonEmail: EditText
    lateinit var etPersonMobileNo: EditText
    lateinit var etPersonAddress: EditText
    lateinit var etPersonPassword: EditText
    lateinit var etPersonConfirmPassword: EditText
    lateinit var btnRegister:Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val intent = Intent(this@RegisterActivity, LoginActivity::class.java)

        etPersonName =findViewById(R.id.etName)
        etPersonEmail = findViewById(R.id.etEmail)
        etPersonMobileNo = findViewById(R.id.etPhoneNumber)
        etPersonAddress = findViewById(R.id.etAddress)
        etPersonPassword = findViewById(R.id.etPassword)
        etPersonConfirmPassword = findViewById(R.id.etConfirmPassword)
        btnRegister = findViewById(R.id.btnRegister)


        btnRegister.setOnClickListener {
            startActivity(intent)
        }



    }

    class DBAsyncTask(val context: Context,val personEntity: PersonEntity):AsyncTask<Void,Void,Boolean>(){

      val db = Room.databaseBuilder(context,PersonDatabase::class.java,"person-db").build()
        override fun doInBackground(vararg p0: Void?): Boolean {

            db.personDao().insertPerson(personEntity)
            db.close()

            return true
        }

    }
}