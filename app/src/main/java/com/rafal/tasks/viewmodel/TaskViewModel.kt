package com.rafal.tasks.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rafal.tasks.api.TaskNetworkRepository
import com.rafal.tasks.database.TaskDatabaseRepository
import com.rafal.tasks.model.Task
import kotlinx.coroutines.launch

class TaskViewModel(
    private val taskDatabaseRepository: TaskDatabaseRepository,
    private val taskNetworkRepository: TaskNetworkRepository
) : ViewModel() {

    var taskList by mutableStateOf(emptyList<Task>())

    fun getAllTasks() {
        viewModelScope.launch {
            try {
                taskList = taskNetworkRepository.getAllTasks().toMutableList()
                taskDatabaseRepository.insertAllTask(taskList)
            } catch (e: Exception) {
                taskList = taskDatabaseRepository.getAllTasks()
            }
        }
    }

}