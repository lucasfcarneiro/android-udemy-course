package com.lucasfagundes.androidudemycourse.feature.task_list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.lucasfagundes.androidudemycourse.databinding.FragmentTaskListBinding

class TaskListAddFragment : Fragment() {

    private lateinit var binding:  FragmentTaskListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentTaskListBinding.inflate(inflater,container,false)
        return binding.root
    }



}