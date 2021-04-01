package com.lucasfagundes.androidudemycourse.feature.atm_consultancy

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.*
import com.lucasfagundes.androidudemycourse.R
import com.lucasfagundes.androidudemycourse.databinding.ActivityAtmConsultancyBinding

class AtmConsultancyActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAtmConsultancyBinding
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAtmConsultancyBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.appBarMainAtm.atmToolbar)

        binding.appBarMainAtm.fab.setOnClickListener {
            sendMail()
        }

        val navController = findNavController(R.id.nav_host_atm_fragment)

        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_atm_main,
                R.id.nav_atm_service,
                R.id.nav_atm_client,
                R.id.nav_atm_about,
                R.id.nav_atm_exit
            ), binding.drawerLayoutAtm
        )
        setupActionBarWithNavController(navController, appBarConfiguration)

        binding.navAtmView.setNavigationItemSelectedListener { menuItem ->
            val id = menuItem.itemId
            if (id == R.id.nav_atm_exit) {
                finish()
            } else {
                NavigationUI.onNavDestinationSelected(menuItem, navController);
            }
            binding.drawerLayoutAtm.closeDrawer(GravityCompat.START)
            true
        }
    }

    private fun sendMail() {
        val email = "contact.lucascarneiro@gmail.com"
        val intent = Intent(Intent.ACTION_SEND)
        intent.putExtra(Intent.EXTRA_EMAIL, email)
        intent.type = "message/rfc822" //search: MIME TYPE
        startActivity(Intent.createChooser(intent, getString(R.string.share)))
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