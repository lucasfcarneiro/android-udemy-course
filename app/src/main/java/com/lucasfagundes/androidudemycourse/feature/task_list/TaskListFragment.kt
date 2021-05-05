package com.lucasfagundes.androidudemycourse.feature.task_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.lucasfagundes.androidudemycourse.R
import com.lucasfagundes.androidudemycourse.databinding.FragmentTaskListBinding
import com.lucasfagundes.androidudemycourse.utils.changeStatusBarColor

class TaskListFragment : Fragment() {

    private lateinit var binding: FragmentTaskListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentTaskListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        changeStatusBarColor(R.color.pink_700)

        (requireActivity() as AppCompatActivity).supportActionBar?.hide()

        



        val taskListAddFragment = TaskListAddFragment()

        binding.taskListFloatButton.setOnClickListener{
            activity?.supportFragmentManager?.beginTransaction()?.apply {
                replace(R.id.nav_host_fragment, taskListAddFragment)
                addToBackStack(null)
                commit()
            }
        }


    }
}