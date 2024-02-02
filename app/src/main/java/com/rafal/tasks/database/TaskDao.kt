package com.rafal.tasks.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.rafal.tasks.model.Task
import retrofit2.http.DELETE

@Dao
interface TaskDao {
    @Insert
    suspend fun insert(task: Task)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(taskList: List<Task>)

    @Query("SELECT * FROM task")
    suspend fun getAll(): List<Task>

    @DELETE
    suspend fun delete(task: Task)
}