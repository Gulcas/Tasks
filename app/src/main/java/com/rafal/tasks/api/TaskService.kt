package com.rafal.tasks.api

import com.rafal.tasks.model.Task
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface TaskService {

    //method and endpoint in ""
    @POST("tasks.json")
    suspend fun add(@Body task: Task)

    @GET("tasks.json")
    suspend fun getAll(): Map<String, Task>
}