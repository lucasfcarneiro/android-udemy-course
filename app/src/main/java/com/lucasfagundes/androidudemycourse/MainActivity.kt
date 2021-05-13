package com.lucasfagundes.androidudemycourse

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.*
import com.lucasfagundes.androidudemycourse.databinding.ActivityMainBinding
import com.lucasfagundes.androidudemycourse.feature.atm_consultancy.AtmConsultancyActivity
import com.lucasfagundes.androidudemycourse.feature.media_player.activities.MediaPlayerActivity

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navController = findNavController(R.id.nav_host_fragment)
        setSupportActionBar(binding.appBarMain.mainToolbar)
        appBarConfiguration = AppBarConfiguration(setOf(R.id.nav_home), binding.drawerLayout)

        setupActionBarWithNavController(navController, appBarConfiguration)
        binding.navView.setNavigationItemSelectedListener { menuItem ->

            when (menuItem.itemId) {
                R.id.nav_atm_consultancy -> {
                    val intent = Intent(this, AtmConsultancyActivity::class.java)
                    startActivity(intent)
                }
                R.id.nav_media_player -> {
                    val intent = Intent(this, MediaPlayerActivity::class.java)
                    startActivity(intent)
                }
                R.id.nav_task_list -> {
                    
                }
                else -> NavigationUI.onNavDestinationSelected(menuItem, navController)
            }
            binding.drawerLayout.closeDrawer(GravityCompat.START)
            true
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}