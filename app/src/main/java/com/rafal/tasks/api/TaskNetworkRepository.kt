package com.rafal.tasks.api

import com.rafal.tasks.model.Task
class TaskNetworkRepository(private val taskService: TaskService) {

    suspend fun addTask(task: Task) {
        taskService.add(task)
    }
    suspend fun getAllTasks(): List<Task> {
        return taskService.getAll().values.toList()
    }
}