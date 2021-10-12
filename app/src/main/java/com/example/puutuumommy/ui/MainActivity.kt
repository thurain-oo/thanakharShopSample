package com.example.puutuumommy.ui

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.puutuumommy.R


class MainActivity : AppCompatActivity() {
    private lateinit var navController : NavController


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContentView(R.layout.activity_main)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController

        setupActionBarWithNavController(navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.menu_call_us -> makePhoneCall()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun makePhoneCall() {
       // Toast.makeText(applicationContext, "Making Ph Call", Toast.LENGTH_LONG).show()
        val intent = Intent(Intent.ACTION_DIAL)
            .setData(Uri.parse("tel:+9595152698"))
        if(this.packageManager.resolveActivity(intent,0) != null) {
            startActivity(intent)
        }

    }
}