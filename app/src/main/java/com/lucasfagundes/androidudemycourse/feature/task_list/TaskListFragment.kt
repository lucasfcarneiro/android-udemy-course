package com.lucasfagundes.androidudemycourse.feature.task_list

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.lucasfagundes.androidudemycourse.R
import com.lucasfagundes.androidudemycourse.databinding.FragmentTaskListBinding
import com.lucasfagundes.androidudemycourse.feature.task_list.adapter.Task
import com.lucasfagundes.androidudemycourse.feature.task_list.adapter.TaskListAdapter
import com.lucasfagundes.androidudemycourse.utils.setStatusBarColor
import com.lucasfagundes.androidudemycourse.utils.setActionBarColor

class TaskListFragment : Fragment() {

    private lateinit var binding: FragmentTaskListBinding
    private lateinit var taskListAdapter: TaskListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentTaskListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setHasOptionsMenu(true)
        setupView()


        binding.taskListFloatButton.setOnClickListener {
            
        }
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                activity?.onBackPressed()
                setStatusBarColor(R.color.purple_700)
                setActionBarColor(R.color.purple_500)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onStart() {
        super.onStart()
        loadTaskList()
    }

    private fun setupView() {
        setStatusBarColor(R.color.pink_700)
        setActionBarColor(R.color.pink_500)
    }

    private fun loadTaskList() {
        taskListAdapter = TaskListAdapter(Task.DUMBLIST)
        binding.recyclerViewTaskList.adapter = taskListAdapter
    }
}