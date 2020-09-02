package com.battisq.to_do.screens.tasks

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.battisq.to_do.R
import com.battisq.to_do.models.Task

class TasksAdapter : RecyclerView.Adapter<TasksAdapter.TasksHolder>() {

    private var mTasks: List<Task> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TasksHolder {
        val view: View = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_task, parent, false)

        val tasksHolder = TasksHolder(view)

        return tasksHolder
    }

    override fun getItemCount(): Int = mTasks.size

    override fun onBindViewHolder(holder: TasksHolder, position: Int) {
        val currentTask: Task = mTasks[position]
        holder.taskText.text = currentTask.text
        holder.checkBox.isChecked = currentTask.isChecked
    }

    fun setTasks(tasks: List<Task>) {
        mTasks = tasks
        notifyDataSetChanged()
    }

    class TasksHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var taskText: TextView = itemView.findViewById(R.id.task_text)
        var checkBox: CheckBox = itemView.findViewById(R.id.checkbox)
    }
}