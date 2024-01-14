package com.example.smp.Activity

import android.content.Context
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.FrameLayout
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.room.Room
import com.example.smp.Fragment.ContractorFragment
import com.example.smp.Fragment.HomeFragment
import com.example.smp.Fragment.MyProfileFragment
import com.example.smp.Fragment.WorkerFragment
import com.example.smp.R
import com.example.smp.database.PersonDatabase
import com.example.smp.database.PersonEntity
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    lateinit var drawerLayout: DrawerLayout
    lateinit var coordinatorLayout: CoordinatorLayout
    lateinit var toolbar: Toolbar
    lateinit var frameLayout: FrameLayout
    lateinit var navigationView: NavigationView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        drawerLayout = findViewById(R.id.drawerLayout)
        coordinatorLayout = findViewById(R.id.coordinatorLayout)
        toolbar = findViewById(R.id.toolbar)
        frameLayout = findViewById(R.id.frame)
        navigationView = findViewById(R.id.navigationView)
        setUpToolbar()

        openHome()


         val actionBarDrawerToggle = ActionBarDrawerToggle(
            this@MainActivity,
            drawerLayout,
            R.string.open_drawer,
            R.string.close_drawer
        )

        drawerLayout.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()
        navigationView.setNavigationItemSelectedListener {

            when(it.itemId)
            {
                R.id.home -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame, HomeFragment())
                        .addToBackStack("Home")
                        .commit()
                    supportActionBar?.title = "Home"
                    drawerLayout.closeDrawers()

                }
                R.id.myprofile -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame, MyProfileFragment())
                        .addToBackStack("MyProfile")
                        .commit()
                    supportActionBar?.title = "My Profile"
                    drawerLayout.closeDrawers()

                }
                R.id.worker -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame, WorkerFragment())
                        .commit()
                    supportActionBar?.title = "Workers Detail"
                    drawerLayout.closeDrawers()

                }
                R.id.contractor ->{
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame, ContractorFragment())
                        .commit()
                    supportActionBar?.title = "Contractors Detail"
                    drawerLayout.closeDrawers()

                }
                R.id.logout -> {
                    setContentView(R.layout.activity_login)

                }
            }
            return@setNavigationItemSelectedListener true
        }

    }

    fun setUpToolbar(){
        setSupportActionBar(toolbar)
        supportActionBar?.title="Toolbar Title"
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId

        if(id == android.R.id.home) {
            drawerLayout.openDrawer(GravityCompat.START)
        }

        return super.onOptionsItemSelected(item)
    }

    fun openHome(){
        val fragment = HomeFragment()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frame,fragment)
        transaction.commit()
        supportActionBar?.title = "Home"
    }

    override fun onBackPressed() {
        val frag = supportFragmentManager.findFragmentById(R.id.frame)

        when(frag)
        {
            !is HomeFragment -> openHome()

            else -> super.onBackPressed()
        }
    }


    class DBAsyncTask(val context: Context, val personEntity: PersonEntity): AsyncTask<Void, Void, Boolean>(){

        val db = Room.databaseBuilder(context, PersonDatabase::class.java,"person-db").build()
        override fun doInBackground(vararg p0: Void?): Boolean {

            val person : PersonEntity? =db.personDao().getPersonbyMobileno(personEntity.person_mobileno.toString())
            db.close()

            return true
        }

    }

}
