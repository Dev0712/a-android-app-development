package com.example.lock

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class LockOptainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        lateinit var item : String



        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lock_optain)


        /*The fragment transaction takes care of the different fragments which will be opened and closed*/
        val fragmentTransaction = supportFragmentManager.beginTransaction()

        /*Getting the id of the clicked item to identify which fragment to display*/
        when (item) {

            /*Opening the pin method fragment*/
            "1" -> {
                val pinmethodFragment = PinMethodFragment()
                fragmentTransaction.replace(R.id.frame, pinmethodFragment)
                fragmentTransaction.commit()
            }

            /*Opening the Qa method fragment*/
            "2" -> {
                val qamethodFragment = QaMethodFragment()
                fragmentTransaction.replace(R.id.frame, qamethodFragment)
                fragmentTransaction.commit()
            }

            /*Opening the Sms method fragment*/
            "3" -> {
                val smsmethodFragment = SmsMethodFragment()
                fragmentTransaction.replace(R.id.frame, smsmethodFragment)
                fragmentTransaction.commit()
            }

            else -> {
                Toast.makeText(
                    this@LockOptainActivity,
                    "please enter correct input",
                    Toast.LENGTH_LONG
                ).show()

                   }
           }
    }
}