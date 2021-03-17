package com.lucasfagundes.androidudemycourse.feature.atm_consultancy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.lucasfagundes.androidudemycourse.R
import com.lucasfagundes.androidudemycourse.databinding.ActivityAtmConsultancyBinding

class AtmConsultancyActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityAtmConsultancyBinding
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAtmConsultancyBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appBarMainAtm.toolbarAtm)

        val navController = findNavController(R.id.nav_host_atm_fragment)

        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home_atm
            ), binding.drawerLayoutAtm
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        binding.navAtmView.setupWithNavController(navController)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.atm, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_atm_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}