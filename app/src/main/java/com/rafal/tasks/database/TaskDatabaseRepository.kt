package com.rafal.tasks.database

import com.rafal.tasks.model.Task

class TaskDatabaseRepository(private val db: AppDatabase) {
    suspend fun insertTask(task: Task) {
        db.taskDao().insert(task)
    }

    suspend fun insertAllTask(taskList: List<Task>) {
        db.taskDao().insertAll(taskList)
    }
    suspend fun getAllTasks(): List<Task> {
        return db.taskDao().getAll()
    }
}