package com.lucasfagundes.androidudemycourse.feature.task_list

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.lucasfagundes.androidudemycourse.R
import com.lucasfagundes.androidudemycourse.databinding.FragmentTaskListBinding
import com.lucasfagundes.androidudemycourse.feature.task_list.adapter.TaskListAdapter
import com.lucasfagundes.androidudemycourse.utils.setActionBarColor
import com.lucasfagundes.androidudemycourse.utils.setStatusBarColor

class TaskListFragment : Fragment() {

    private lateinit var binding: FragmentTaskListBinding
    private lateinit var taskListAdapter: TaskListAdapter
    private lateinit var listOfTitle: List<String>

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

        listOfTitle = listOf("Um Sonho de Liberdade","O Poderoso Chefão","O Poderoso Chefão II","O Poderoso Chefão III")

        binding.taskListFloatButton.setOnClickListener {
            findNavController().navigate(TaskListFragmentDirections.actionTaskListFragmentToTaskListAddFragment())
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                activity?.onBackPressed()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onStart() {
        super.onStart()
        loadTaskList(listOfTitle)
    }

    private fun setupView() {
        setStatusBarColor(R.color.pink_700)
        setActionBarColor(R.color.pink_500)
    }

    private fun loadTaskList(listOfTitle: List<String>) {
        taskListAdapter = TaskListAdapter(listOfTitle)
        binding.taskListRecyclerView.adapter = taskListAdapter
    }
}