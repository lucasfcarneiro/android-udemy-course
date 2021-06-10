package com.lucasfagundes.androidudemycourse.feature.my_annotations

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import org.koin.androidx.viewmodel.ext.android.viewModel
import com.google.android.material.snackbar.Snackbar
import com.lucasfagundes.androidudemycourse.R
import com.lucasfagundes.androidudemycourse.databinding.FragmentMyAnnotationsBinding
import com.lucasfagundes.androidudemycourse.utils.setStatusBarColor
import com.lucasfagundes.androidudemycourse.utils.snackBar

class MyAnnotationsFragment : Fragment() {

    private lateinit var binding: FragmentMyAnnotationsBinding
    private val viewModel: MyAnnotationViewModel by viewModel()

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

        handleObserver()

        with(binding) {
            arrowBackMyAnnotations.setOnClickListener() {
                activity?.onBackPressed()
            }
            floatButton.setOnClickListener {
                viewModel.saveStringOnPreference(textInputNotes.text.toString())
            }
        }
    }

    private fun handleObserver() {
        val note = Observer<String> {
            binding.textInputNotes.setText(it)
        }
        val error = Observer<Boolean> {
            handleSnackbar(it)
        }
        viewModel.note.observe(viewLifecycleOwner, note)
        viewModel.error.observe(viewLifecycleOwner, error)
    }

    private fun handleSnackbar(error: Boolean) {
        if (error) {
            snackBar(requireView(), R.string.empty_field, Snackbar.LENGTH_LONG)
        } else {
            snackBar(requireView(), R.string.modification_saved, Snackbar.LENGTH_LONG)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        (requireActivity() as AppCompatActivity).supportActionBar?.show()
        setStatusBarColor(R.color.purple_700)
    }
}
