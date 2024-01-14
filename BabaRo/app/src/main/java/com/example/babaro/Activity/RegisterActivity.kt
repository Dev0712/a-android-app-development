package com.example.babaro.Activity

import android.content.Context
import android.content.Intent
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.room.Room
import com.example.babaro.R
import com.example.babaro.database.PersonDatabase
import com.example.babaro.database.PersonEntity

class RegisterActivity : AppCompatActivity() {

    lateinit var etMobileNumber: EditText
    lateinit var etName: EditText
    lateinit var etAddress : EditText
    lateinit var btnRegister: Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        etMobileNumber=findViewById(R.id.etPhoneNumber)
        etName=findViewById(R.id.etName)
        etAddress= findViewById(R.id.etAddress)
        btnRegister=findViewById(R.id.btnRegister)

        btnRegister.setOnClickListener {
            val intent = Intent(this@RegisterActivity, MainActivity::class.java)

            Toast.makeText(this@RegisterActivity,"Register Successfully",Toast.LENGTH_LONG).show()

            startActivity(intent)

        }

    }

//
//    class DBAsyncTask(val context: Context, val personEntity: PersonEntity):
//        AsyncTask<Void, Void, Boolean>(){
//
//        val db = Room.databaseBuilder(context, PersonDatabase::class.java,"person-db").build()
//        override fun doInBackground(vararg p0: Void?): Boolean {
//
//            db.personDao().insertPerson(personEntity)
//            db.close()
//
//            return true
//        }
//
//    }
}