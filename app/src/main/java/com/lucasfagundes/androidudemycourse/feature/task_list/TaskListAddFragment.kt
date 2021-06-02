package com.lucasfagundes.androidudemycourse.feature.task_list

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.lucasfagundes.androidudemycourse.R
import com.lucasfagundes.androidudemycourse.databinding.FragmentTaskListAddBinding
import com.lucasfagundes.androidudemycourse.feature.task_list.dbHelper.DbHelper
import com.lucasfagundes.androidudemycourse.feature.task_list.dbHelper.TaskDAO

class TaskListAddFragment : Fragment() {

    private lateinit var binding: FragmentTaskListAddBinding
    private lateinit var taskText: String
    private lateinit var taskDAO: TaskDAO
    private lateinit var task: Task
    private lateinit var db: DbHelper

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentTaskListAddBinding.inflate(inflater, container, false)
        setHasOptionsMenu(true)

        taskText = binding.taskListAddInputText.toString()
        taskDAO = TaskDAO(requireContext())
        db = DbHelper(requireContext())
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.task_list, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                activity?.onBackPressed()
                true
            }
            R.id.save_task_list -> {
                //TODO save task

                task = Task()
                task.setNameTask(taskText)
                taskDAO.saveTask(task)

                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}