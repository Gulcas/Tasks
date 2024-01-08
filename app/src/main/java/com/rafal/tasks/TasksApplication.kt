package com.rafal.tasks

import android.app.Application
import android.util.Log
import com.rafal.tasks.api.ServiceConfiguration
import com.rafal.tasks.api.TaskNetworkRepository
import com.rafal.tasks.database.DatabaseConfiguration
import com.rafal.tasks.database.TaskDao
import com.rafal.tasks.database.TaskDatabaseRepository
import com.rafal.tasks.viewmodel.TaskViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module

class TasksApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        Log.d("MyTasksApp", "Application onCreate()")

        startKoin {
            androidContext(this@TasksApplication)
            modules(
                module {
                    single { DatabaseConfiguration.getDatabase(androidContext()) }
                    factory { TaskDatabaseRepository(get()) }

                    single { ServiceConfiguration.taskService }
                    factory { TaskNetworkRepository(get()) }

                    viewModel { TaskViewModel(get(), get()) }
                }
            )
        }
    }
}