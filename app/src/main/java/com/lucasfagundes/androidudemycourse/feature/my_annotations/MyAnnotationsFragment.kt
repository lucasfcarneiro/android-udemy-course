package com.lucasfagundes.androidudemycourse.feature.my_annotations

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

class MyAnnotationsFragment : Fragment() {

    private lateinit var binding: FragmentMyAnnotationsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentMyAnnotationsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.floatButton.setOnClickListener {
            Snackbar.make(it, "Modificações salvas", Snackbar.LENGTH_LONG).setAction("Action", null)
                .show()
        }

        changeStatusBarColor(R.color.black)

        (requireActivity() as AppCompatActivity).supportActionBar?.hide()

        binding.testeseta.setOnClickListener {
        }

//        binding.toolbarMyAnnotation.setNavigationIcon(R.drawable.ic_arrow_back)
//        binding.toolbarMyAnnotation.setNavigationOnClickListener {
//            requireActivity().onBackPressed()
//        }
    }

    override fun onDestroy() {
        super.onDestroy()
        (requireActivity() as AppCompatActivity).supportActionBar?.show()
        changeStatusBarColor(R.color.purple_700)
    }
}
