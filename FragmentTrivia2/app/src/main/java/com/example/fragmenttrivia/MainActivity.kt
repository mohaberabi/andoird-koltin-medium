

package com.example.fragmenttrivia

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavArgs
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.navigateUp
import com.example.fragmenttrivia.R
import com.example.fragmenttrivia.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    private lateinit var drawerLayout: DrawerLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        @Suppress("UNUSED_VARIABLE")
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        val navController = this.findNavController(R.id.navHostFragment)

        drawerLayout = binding.drawerLayout
        NavigationUI.setupActionBarWithNavController(this , navController,drawerLayout)

        NavigationUI.setupWithNavController(binding.navView,navController)

        navController.addOnDestinationChangedListener(NavController.OnDestinationChangedListener{
            controller : NavController , destination : NavDestination , bundle : Bundle? ->

            if (destination.id==navController.graph.startDestinationId){
                drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED)
            }
            else {
                drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)

            }
        })
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.navHostFragment)
     return NavigationUI.navigateUp(navController,drawerLayout)
    }
}
