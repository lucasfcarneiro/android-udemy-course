package com.lucasfagundes.androidudemycourse.feature.task_list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.lucasfagundes.androidudemycourse.databinding.FragmentTaskListAddBinding

class TaskListAddFragment : Fragment() {

    private lateinit var binding:  FragmentTaskListAddBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentTaskListAddBinding.inflate(inflater,container,false)
        return binding.root
    }



}