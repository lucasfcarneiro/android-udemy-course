package com.lucasfagundes.androidudemycourse.feature.my_annotations

import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.lucasfagundes.androidudemycourse.R
import com.lucasfagundes.androidudemycourse.databinding.FragmentMyAnnotationsBinding
import com.lucasfagundes.androidudemycourse.utils.changeStatusBarColor
import android.widget.Toast as Toast

const val FILE_PREFERENCE = "filePreference"

class MyAnnotationsFragment : Fragment() {

    private lateinit var binding: FragmentMyAnnotationsBinding
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentMyAnnotationsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        changeStatusBarColor(R.color.black)
        (requireActivity() as AppCompatActivity).supportActionBar?.hide()

        binding.floatButton.setOnClickListener {
            Snackbar.make(it, R.string.modification_saved, Snackbar.LENGTH_LONG)
                .setAction("Action", null)
                .show()
            validateField()
        }

        binding.arrowBackMyAnnotations.setOnClickListener {
            requireActivity().onBackPressed()
        }

        sharedPreferences = requireActivity().getSharedPreferences(FILE_PREFERENCE, 0)
        setupPreference()
    }

    private fun validateField() {
        if (binding.textInputAnnotations.text.isNullOrEmpty()) {
            Toast.makeText(activity, "escreve um nome ai sô", Toast.LENGTH_SHORT).show()
        } else {
            saveInSharedPreference()
        }
    }

    private fun setupPreference() {
        if (sharedPreferences.contains("note")) {
            val noteGetFromPreference = sharedPreferences.getString("note", "Nota não encontrada")

            if (noteGetFromPreference != null) {
                binding.textInputAnnotations.setText(noteGetFromPreference)
            }
        }
    }

    private fun saveInSharedPreference() {
        val note = binding.textInputAnnotations.text.toString()

        sharedPreferences = requireActivity().getSharedPreferences(FILE_PREFERENCE, 0)
        sharedPreferences.edit().apply() {
            putString("note", note)
            apply()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        (requireActivity() as AppCompatActivity).supportActionBar?.show()
        changeStatusBarColor(R.color.purple_700)
    }
}
