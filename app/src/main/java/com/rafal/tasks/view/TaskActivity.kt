package com.rafal.tasks.view

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rafal.tasks.HomeActivity
import com.rafal.tasks.R
import com.rafal.tasks.model.ColorType
import com.rafal.tasks.model.Task
import com.rafal.tasks.model.TaskOperationStatus
import com.rafal.tasks.ui.theme.Blue
import com.rafal.tasks.ui.theme.TasksTheme
import com.rafal.tasks.viewmodel.TaskViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class TaskActivity : ComponentActivity() {

    val taskViewModel by viewModel<TaskViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val editTask: Task? = intent.getSerializableExtra("edit_task") as? Task

        setContent {
            TasksTheme() {
                Surface(Modifier.fillMaxSize()) {
                    TaskView(editTask)
                    observeAddTaskStatus()
                }
            }
        }
    }

    private fun observeAddTaskStatus() {
        when (taskViewModel.addEditTaskStatus) {
            TaskOperationStatus.SUCCESS -> {
                val intent = Intent(this, HomeActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
                startActivity(intent)
                finish()
            }

            TaskOperationStatus.ERROR -> {
                Toast.makeText(this, "Connection problem. Try again", Toast.LENGTH_LONG).show()
            }

            TaskOperationStatus.LOADING, TaskOperationStatus.UNKNOWN -> {}
        }
    }

    @Composable
    fun TaskView(editTask: Task?) {
        val context = LocalContext.current
        val taskColors = ColorType.values() //wartości enuma

        var currentColor by rememberSaveable {
            mutableStateOf(editTask?.colorType ?: taskColors.first())
        }
        var titleText by rememberSaveable { mutableStateOf(editTask?.title ?: "") }
        var descriptionText by rememberSaveable { mutableStateOf(editTask?.description ?: "") }

        Column(
            modifier = Modifier
                .padding(20.dp)
        ) {
            Text(
                text = "Tasks",
                fontSize = 30.sp
            )
            Spacer(
                modifier = Modifier
                    .padding(20.dp)
            )
            Card(
                colors = CardDefaults.cardColors(containerColor = currentColor.color), //pobiera kolor z enuma
                elevation = CardDefaults.elevatedCardElevation(defaultElevation = 10.dp)
            ) {
                val outlinedTextStyle = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.DarkGray
                )

                val outlinedTextFieldColors = OutlinedTextFieldDefaults.colors(
                    focusedLabelColor = Blue,
                    unfocusedBorderColor = Color.Gray
                )
                OutlinedTextField(
                    value = titleText,
                    onValueChange = { titleText = it },
                    label = { Text(text = "Title") },
                    textStyle = outlinedTextStyle,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    colors = outlinedTextFieldColors
                )
                OutlinedTextField(
                    value = descriptionText,
                    onValueChange = { descriptionText = it },
                    label = { Text(text = "Description") },
                    textStyle = outlinedTextStyle,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    colors = outlinedTextFieldColors
                )
            }
            Spacer(
                modifier = Modifier
                    .padding(20.dp)
            )
            LazyRow() {
                items(items = taskColors) { colorType ->
                    Button(
                        onClick = { currentColor = colorType },
                        shape = CircleShape,
                        colors = ButtonDefaults.buttonColors(containerColor = colorType.color), //pobiera kolor z enuma
                        elevation = ButtonDefaults.elevatedButtonElevation(defaultElevation = 8.dp),
                        border = BorderStroke(
                            2.dp,
                            if (currentColor == colorType) Color.Gray else colorType.color //pobiera kolor z enuma
                        ),
                        modifier = Modifier
                            .padding(horizontal = 8.dp)
                            .size(40.dp)
                    ) {}
                }
            }
            Spacer(
                modifier = Modifier
                    .padding(20.dp)
            )
            Button(
                modifier = Modifier
                    .fillMaxWidth(),
                onClick = { //przypisanie wartości do zmiennych w modelu Task
                    if (editTask == null) {
                        val task = Task(
                            title = titleText,
                            description = descriptionText,
                            colorType = currentColor
                        )
                        taskViewModel.addTask(task)
                    } else {
                        val task = editTask.copy(
                            title = titleText,
                            description = descriptionText,
                            colorType = currentColor
                        )
                        taskViewModel.editTask(task)
                    }
                }
            ) {
                if (taskViewModel.addEditTaskStatus == TaskOperationStatus.LOADING) {
                    CircularProgressIndicator(color = Color.White, modifier = Modifier.size(20.dp))
                } else {
                    Text(text = "Save")
                }
            }
            Image(
                painter = painterResource(R.drawable.mu),
                contentDescription = null,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
            )
        }
    }
}