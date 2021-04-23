package com.lucasfagundes.androidudemycourse.feature.my_annotations

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.google.android.material.snackbar.Snackbar
import com.lucasfagundes.androidudemycourse.databinding.FragmentMyAnnotationsBinding

class MyAnnotationsFragment : Fragment() {

    private lateinit var binding : FragmentMyAnnotationsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.floatButton.scaleType = ImageView.ScaleType.CENTER

        binding.floatButton.setOnClickListener{
            view -> Snackbar.make(view, "teste teste",Snackbar.LENGTH_LONG).setAction("Action",null).show()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentMyAnnotationsBinding.inflate(inflater,container, false)
        return binding.root
    }
}