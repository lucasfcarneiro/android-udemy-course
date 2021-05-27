package com.lucasfagundes.androidudemycourse.feature.task_list

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.lucasfagundes.androidudemycourse.R
import com.lucasfagundes.androidudemycourse.databinding.FragmentTaskListAddBinding

class TaskListAddFragment : Fragment() {

    private lateinit var binding: FragmentTaskListAddBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentTaskListAddBinding.inflate(inflater, container, false)
        setHasOptionsMenu(true)
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
            else -> super.onOptionsItemSelected(item)
        }
    }
}