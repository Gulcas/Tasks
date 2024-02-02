package com.rafal.tasks.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rafal.tasks.api.TaskNetworkRepository
import com.rafal.tasks.database.TaskDatabaseRepository
import com.rafal.tasks.model.Task
import com.rafal.tasks.model.TaskIdResponse
import com.rafal.tasks.model.TaskOperationStatus
import kotlinx.coroutines.launch

class TaskViewModel(
    private val taskDatabaseRepository: TaskDatabaseRepository,
    private val taskNetworkRepository: TaskNetworkRepository
) : ViewModel() {

    var taskList by mutableStateOf(emptyList<Task>())
    var addEditTaskStatus by mutableStateOf(TaskOperationStatus.UNKNOWN)
    var getAllTaskStatus by mutableStateOf(TaskOperationStatus.UNKNOWN)
    var sendSmsTaskStatus by mutableStateOf<Task?>(null)

    fun getAllTasks() {
        viewModelScope.launch {
            try {
                getAllTaskStatus = TaskOperationStatus.LOADING
                taskList = taskNetworkRepository.getAllTasks().toMutableList()
                taskDatabaseRepository.insertAllTask(taskList)
                getAllTaskStatus = TaskOperationStatus.SUCCESS
            } catch (e: Exception) {
                taskList = taskDatabaseRepository.getAllTasks()
                getAllTaskStatus = TaskOperationStatus.ERROR
            }
        }
    }

    fun addTask(task: Task) {
        viewModelScope.launch {
            try {
                addEditTaskStatus = TaskOperationStatus.LOADING
                val response: TaskIdResponse = taskNetworkRepository.addTask(task)
                taskDatabaseRepository.insertTask(task.copy(id = response.name))
                addEditTaskStatus = TaskOperationStatus.SUCCESS
            } catch (e: Exception) {
                addEditTaskStatus = TaskOperationStatus.ERROR
            }
        }
    }

    fun deleteTask(task: Task) {
        viewModelScope.launch {
            try {
                taskNetworkRepository.deleteTask(task.id)
                taskDatabaseRepository.deleteTask(task)
                removeTaskFroList(task)
            } catch (e: Exception) {

            }
        }
    }

    private fun removeTaskFroList(task: Task) {
//        val mutableTaskList = taskList.toMutableList()
//        mutableTaskList.remove(task)
//        taskList = mutableTaskList
        //zapis powyżej robi to samo co ten poniżej
        taskList.toMutableList().also {
            it.remove(task)
            taskList = it
        }
    }

    fun editTask(task: Task) {
        viewModelScope.launch {
            try {
                addEditTaskStatus = TaskOperationStatus.LOADING
                taskNetworkRepository.editTask(task)
                taskDatabaseRepository.editTask(task)
                addEditTaskStatus = TaskOperationStatus.SUCCESS
            } catch (e: Exception) {
                addEditTaskStatus = TaskOperationStatus.ERROR
            }
        }
    }
}