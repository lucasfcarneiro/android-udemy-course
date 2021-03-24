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

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.appBarMain.toolbar)

        val navController = findNavController(R.id.nav_host_fragment)

        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home,
                R.id.nav_media_player,
                R.id.nav_atm_consultancy,
                R.id.nav_recycler_view,
                R.id.nav_tip_calculator,
                R.id.nav_alcohol_gasoline,
                R.id.nav_rock_paper_scissors,
                R.id.nav_random_number
            ), binding.drawerLayout
        )

        setupActionBarWithNavController(navController, appBarConfiguration)
        binding.navView.setNavigationItemSelectedListener { menuItem ->
            val id = menuItem.itemId
            if (id == R.id.nav_atm_consultancy) {
                val intent = Intent(this, AtmConsultancyActivity::class.java)
                startActivity(intent)
            } else {
                NavigationUI.onNavDestinationSelected(menuItem, navController);
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