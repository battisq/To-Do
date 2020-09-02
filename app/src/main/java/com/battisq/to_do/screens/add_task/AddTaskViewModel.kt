package com.battisq.to_do.screens.add_task

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.battisq.to_do.models.Task
import com.battisq.to_do.utilits.DATABASE
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddTaskViewModel : ViewModel() {
    fun insert(task: Task, onSuccess: () -> Unit) {
        viewModelScope.launch (Dispatchers.IO) {
            DATABASE.getTaskDao().insert(task)
            onSuccess()
        }
    }
}