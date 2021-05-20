package com.lucasfagundes.androidudemycourse.feature.task_list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.lucasfagundes.androidudemycourse.databinding.FragmentTaskListMainBinding

class TaskListMainFragment : Fragment() {

    private lateinit var binding: FragmentTaskListMainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentTaskListMainBinding.inflate(inflater, container, false)
        return binding.root
    }
}