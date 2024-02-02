package com.rafal.tasks

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.room.Database
import com.rafal.tasks.api.ServiceConfiguration
import com.rafal.tasks.api.TaskNetworkRepository
import com.rafal.tasks.database.DatabaseConfiguration
import com.rafal.tasks.database.TaskDatabaseRepository
import com.rafal.tasks.model.Task
import com.rafal.tasks.model.TaskOperationStatus
import com.rafal.tasks.util.StorageOperations
import com.rafal.tasks.view.TaskActivity
import com.rafal.tasks.viewmodel.TaskViewModel
import kotlinx.coroutines.runBlocking
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel


//var taskList = mutableListOf<Task>()

class HomeActivity : ComponentActivity() {
    //    val taskDataBaseRepository by inject<TaskDatabaseRepository>()
//    val taskNetworkRepository by inject<TaskNetworkRepository>()
    val taskViewModel by viewModel<TaskViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("MyTasksApplication", "HomeActivity onCreate()")

        taskViewModel.getAllTasks()
        /*
                getAllTasksViaNetwork()

                val task =
                    intent.getSerializableExtra("task") as? Task //pobieramy obiekt z intentu i rzutujemy na Task
                task?.let {

                    taskList.add(task)
        //            StorageOperations.writeTaskList(this, taskList)
                    insertTaskToDatabase(task)

                    addTaskViaNetwork(task)

                }
                */

        setContent {
//            HomeText(welcomeValue)
            HomeView()
            observerGetAllTaskStatus()
        }
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        Log.d("MyTaskApp", "HomeActivity onNewIntent")
        taskViewModel.getAllTasks()
    }

    private fun observerGetAllTaskStatus() {
        if (taskViewModel.getAllTaskStatus == TaskOperationStatus.ERROR) {
            Toast.makeText(this, "Task loaded from local storage.", Toast.LENGTH_LONG).show()
        }
    }

    /*
        private fun insertTaskToDatabase(task: Task) {
            runBlocking {
                taskDataBaseRepository.insertTask(task)
            }
        }
        private fun getAllTasksFromDatabase() {
            runBlocking {
                taskList = taskDataBaseRepository.getAllTasks().toMutableList()
            }
        }

        private fun insertAllTasksToDatabase(taskList: List<Task>) {
            runBlocking {
                taskDataBaseRepository.insertAllTask(taskList)
            }
        }

        private fun getAllTasksViaNetwork() {
            val context = this
            runBlocking {
                try {
                    taskList = taskNetworkRepository.getAllTasks().toMutableList()
    //                StorageOperations.writeTaskList(context, taskList)
                    insertAllTasksToDatabase(taskList)
                } catch (e: Exception) {
                    Log.e("HomeActivity", "Error: $e")
    //                taskList = StorageOperations.readTaskList(context).toMutableList()
                    getAllTasksFromDatabase()
                    Toast.makeText(context, "Dane z pamięci lokalnej", Toast.LENGTH_SHORT).show()
                }

            } //pobieramy wszystkie zadania z serwera
        }

        private fun addTaskViaNetwork(task: Task) {
            val context = this
            runBlocking {
                try {
                    taskNetworkRepository.addTask(task)
                } catch (e: Exception) {
                    Log.e("HomeActivity", "Error: $e")
                    Toast.makeText(context, "Problem, spróbuj jeszcze raz", Toast.LENGTH_SHORT).show()
                }
            }
        }
    */
    @Composable
    fun TaskListView() {
        Column(
            modifier = Modifier
                .padding(horizontal = 20.dp)
        ) {
            Text(
                text = "Task list",
                fontSize = 30.sp,
                modifier = Modifier
                    .padding(top = 20.dp)
            )
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize(),
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(items = taskViewModel.taskList) { task ->
                    Card(
                        colors = CardDefaults.cardColors(containerColor = task.colorType.color),
                        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 10.dp)
                    ) {
                        Row() {
                            Column(
                                modifier = Modifier
                                    .padding(16.dp)
                                    .weight(1f)
                            ) {
                                Text(
                                    text = task.title,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 20.sp
                                )
                                Spacer(modifier = Modifier.height(8.dp))
                                Text(
                                    text = task.description
                                )
                            }
                            Column(
                                modifier = Modifier.padding(top = 8.dp, bottom = 8.dp, end = 8.dp)
                            ) {
                                IconButton(
                                    onClick = { taskViewModel.deleteTask(task) },
                                    modifier = Modifier.size(25.dp)
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.Close,
                                        contentDescription = "delete task"
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    @Composable
    fun HomeView() {

        val context = LocalContext.current //pobieramy context, z onClicka nie możemy tego zrobić

        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            when (taskViewModel.getAllTaskStatus) {
                TaskOperationStatus.SUCCESS, TaskOperationStatus.ERROR -> {
                    if (taskViewModel.taskList.isEmpty()) {
                        Text(
                            text = "Empty List",
                            fontSize = 20.sp,
                            modifier = Modifier
                                .align(Alignment.Center)
                        )
                    } else {
                        TaskListView()
                    }
                }

                TaskOperationStatus.LOADING -> {
                    CircularProgressIndicator(Modifier.align(Alignment.Center))
                }

                TaskOperationStatus.UNKNOWN -> {}
            }


            FloatingActionButton(
                onClick = {
                    val intent = Intent(context, TaskActivity::class.java)
                    startActivity(intent)
//                    finish() //zamykamy activity
                },
                modifier = Modifier
                    .padding(16.dp)
                    .align(Alignment.BottomEnd)
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Add task")
            }
        }
    }

    @Composable
    fun HomeText(txt: String?) {
        Text(text = txt ?: "HomeActivity") //odbieramy wartość z intentu lub domyślną
    }
}