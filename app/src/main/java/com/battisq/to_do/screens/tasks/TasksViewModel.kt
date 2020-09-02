package com.battisq.to_do.screens.tasks

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.battisq.to_do.models.Task
import com.battisq.to_do.utilits.DATABASE

class TasksViewModel : ViewModel() {

    var tasks: LiveData<List<Task>> = DATABASE.getTaskDao().gelAllTasks()

}