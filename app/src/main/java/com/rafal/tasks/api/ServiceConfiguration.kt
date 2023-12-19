package com.rafal.tasks.api

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


object ServiceConfiguration {
//    var retrofit = Retrofit.Builder()
//        .baseUrl("https://api.github.com/")
//        .addConverterFactory(GsonConverterFactory.create())
//        .build()
//
//    var service: GitHubService = retrofit.create(GitHubService::class.java)
    private val retrofit = Retrofit.Builder()
    .baseUrl("https://tasks-android-kurs-f213e-default-rtdb.europe-west1.firebasedatabase.app/")
    .addConverterFactory(MoshiConverterFactory.create())
    .build()

    val taskService: TaskService = retrofit.create(TaskService::class.java)
}