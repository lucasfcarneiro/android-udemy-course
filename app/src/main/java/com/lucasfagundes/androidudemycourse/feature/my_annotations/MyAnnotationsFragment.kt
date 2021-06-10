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
import com.lucasfagundes.androidudemycourse.utils.setStatusBarColor
import com.lucasfagundes.androidudemycourse.utils.snackBar

//const val FILE_PREFERENCE = "filePreference"
const val NOTE_KEY = "note"

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

        setStatusBarColor(R.color.black)
        (requireActivity() as AppCompatActivity).supportActionBar?.hide()

        binding.floatButton.setOnClickListener {
            validateField()
        }

        binding.arrowBackMyAnnotations.setOnClickListener {
            requireActivity().onBackPressed()
        }

        getNoteFromSharedPreference()
    }

    private fun validateField() {
        if (binding.textInputNotes.text.isNullOrEmpty()) {
            snackBar(requireView(), R.string.empty_field, Snackbar.LENGTH_LONG )
        } else {
            saveInSharedPreference()
            snackBar(requireView(), R.string.modification_saved, Snackbar.LENGTH_LONG)
        }
    }

//    private fun getNoteFromSharedPreference() {
//        sharedPreferences = requireActivity().getSharedPreferences(FILE_PREFERENCE, 0)
//
//        if (sharedPreferences.contains(NOTE_KEY)) {
//            val recoveredNote = sharedPreferences.getString(NOTE_KEY, getString(R.string.note_not_found))
//
//            if (recoveredNote != null) {
//                binding.textInputNotes.setText(recoveredNote)
//            }
//        }
//    }
//
//    private fun saveInSharedPreference() {
//        val note = binding.textInputNotes.text.toString()
//
//        sharedPreferences = requireActivity().getSharedPreferences(FILE_PREFERENCE, 0)
//        sharedPreferences.edit().apply() {
//            putString(NOTE_KEY, note)
//            apply()
//        }
//    }

    override fun onDestroy() {
        super.onDestroy()
        (requireActivity() as AppCompatActivity).supportActionBar?.show()
        setStatusBarColor(R.color.purple_700)
    }
}
