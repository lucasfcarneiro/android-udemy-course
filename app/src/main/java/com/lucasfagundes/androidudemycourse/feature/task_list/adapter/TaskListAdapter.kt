package com.lucasfagundes.androidudemycourse.feature.task_list.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.lucasfagundes.androidudemycourse.databinding.TaskListItemRecyclerViewBinding

class TaskListAdapter(private val test: List<Task>) :
    RecyclerView.Adapter<TaskListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = TaskListItemRecyclerViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = test.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(test[position])
    }

    inner class ViewHolder(private val binding: TaskListItemRecyclerViewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(s: Task) {
            binding.taskTextView.text = s.title
        }
    }
}