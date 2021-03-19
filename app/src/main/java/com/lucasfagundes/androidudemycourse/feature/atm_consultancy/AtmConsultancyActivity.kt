package com.lucasfagundes.androidudemycourse.feature.atm_consultancy

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.lucasfagundes.androidudemycourse.R
import com.lucasfagundes.androidudemycourse.databinding.ActivityAtmConsultancyBinding

class AtmConsultancyActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAtmConsultancyBinding
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAtmConsultancyBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appBarMainAtm.toolbarAtm)

        val fab: View = findViewById(R.id.fab)
        fab.setOnClickListener { view ->
            sendMail()
        }

        val navController = findNavController(R.id.nav_host_atm_fragment)

        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_atm_main,
                R.id.nav_atm_service,
                R.id.nav_atm_client,
                R.id.nav_atm_contact,
                R.id.nav_atm_about
            ), binding.drawerLayoutAtm
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        binding.navAtmView.setupWithNavController(navController)
    }

    private fun sendMail() {
        val email = "contact.lucascarneiro@gmail.com"
        val intent = Intent(Intent.ACTION_SEND)
        intent.putExtra(Intent.EXTRA_EMAIL, email)
        intent.type = "message/rfc822" //search: MIME TYPE
        startActivity(Intent.createChooser(intent,getString(R.string.share)))
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