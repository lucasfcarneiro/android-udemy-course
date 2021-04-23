package com.lucasfagundes.androidudemycourse.feature.atm_consultancy.fragments.about

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.lucasfagundes.androidudemycourse.R
import mehdi.sakout.aboutpage.AboutPage

class AboutAtmFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return AboutPage(context)
            .isRTL(false)
            .enableDarkMode(false)
            .setImage(R.drawable.logo_atm)
            .addEmail("contact.lucascarneiro@gmail.com")
            .addGitHub("lucasfcarneiro")
            .create()
    }
}