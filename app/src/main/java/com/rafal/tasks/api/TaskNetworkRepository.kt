package com.rafal.tasks.api

import com.rafal.tasks.model.Task
import com.rafal.tasks.model.TaskIdResponse

class TaskNetworkRepository(private val taskService: TaskService) {

    suspend fun addTask(task: Task): TaskIdResponse {
        return taskService.add(task)
    }

    suspend fun getAllTasks(): List<Task> {
        return taskService.getAll().map { element -> element.value.copy(id = element.key) }
    }
    suspend fun deleteTask(taskId: String) {
        taskService.deleteTask(taskId)
    }
}