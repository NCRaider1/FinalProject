package com.hfad.finalproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.google.android.material.appbar.MaterialToolbar
import android.view.Menu
import android.view.MenuItem
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.onNavDestinationSelected
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       setContentView(R.layout.activity_main)
//        val button = findViewById<Button>(R.id.sButton)
//
//        button.setOnClickListener{
//            val myFragment = SearchFragment()
//            val fragmentManager = supportFragmentManager
//            val fragmentTransaction = fragmentManager.beginTransaction()
//            fragmentTransaction.replace(R.id.fragment_container, myFragment)
//            fragmentTransaction.addToBackStack(null)
//            fragmentTransaction.commit()
//            }
//    }

//        val toolbar = findViewById<MaterialToolbar>(R.id.materialToolbar)
//        setSupportActionBar(toolbar)
//        val navHostFragment = supportFragmentManager
//            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment
//        val navController = navHostFragment.navController
//        val builder = AppBarConfiguration.Builder(navController.graph)
//        val appBarConfiguration = builder.build()
//        toolbar.setupWithNavController(navController, appBarConfiguration)
}

//    override fun onCreateOptionsMenu(menu: Menu): Boolean {
//       menuInflater.inflate(R.menu.menu_toolbar, menu)
//        return super.onCreateOptionsMenu(menu)
//    }
//
//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        val navController = findNavController(R.id.nav_host_fragment)
//        return item.onNavDestinationSelected(navController)
//                ||super.onOptionsItemSelected(item)
//    }
}