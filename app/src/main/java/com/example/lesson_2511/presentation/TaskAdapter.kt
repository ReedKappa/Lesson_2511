package com.example.lesson_2511.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.lesson_2511.DATE_FORMAT
import com.example.lesson_2511.data.module.Task
import com.example.lesson_2511.databinding.ItemTaskBinding
import java.text.SimpleDateFormat
import java.util.Locale

class TaskAdapter: ListAdapter<Task, TaskAdapter.TaskViewHolder>(TaskDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val binding = ItemTaskBinding.inflate(inflater, parent, false)
        return TaskViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class TaskViewHolder(
        private val binding: ItemTaskBinding
    ): RecyclerView.ViewHolder(binding.root) {
        fun bind(task: Task) = with(binding) {
            val formatter = SimpleDateFormat(DATE_FORMAT, Locale.getDefault())
            itemTaskTitle.text = task.title
            itemTaskDescription.text = task.description
            itemTaskStartTime.text = formatter.format(task.startTime)
            itemTaskEndTime.text = formatter.format(task.endTime)
        }
    }

    class TaskDiffUtil: DiffUtil.ItemCallback<Task>() {

        override fun areItemsTheSame(oldItem: Task, newItem: Task): Boolean =
            oldItem == newItem

        override fun areContentsTheSame(oldItem: Task, newItem: Task): Boolean =
            oldItem == newItem
    }
}

