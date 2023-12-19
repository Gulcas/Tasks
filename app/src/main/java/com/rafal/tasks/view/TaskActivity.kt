package com.rafal.tasks.view

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rafal.tasks.HomeActivity
import com.rafal.tasks.model.ColorType
import com.rafal.tasks.model.Task

class TaskActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TaskView()
        }
    }

    @Composable
    fun TaskView() {

        val context = LocalContext.current

        val taskColors = ColorType.values() //wartości enuma
        var currentColor by remember { mutableStateOf(taskColors.first()) }
        var titleText by remember { mutableStateOf("") }
        var descriptionText by remember { mutableStateOf("") }

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
                OutlinedTextField(
                    value = titleText,
                    onValueChange = { titleText = it },
                    label = { Text(text = "Title") },
                    textStyle = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                )
                OutlinedTextField(
                    value = descriptionText,
                    onValueChange = { descriptionText = it },
                    label = { Text(text = "Description") },
                    textStyle = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
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
                    val task = Task(
                        title = titleText,
                        description = descriptionText,
                        colorType = currentColor
                    )
                    val intent = Intent(context, HomeActivity::class.java)
                    intent.putExtra("task", task) //obiekty muszą być serializowane
                    startActivity(intent)
                    finish()
                }
            ) {
                Text(text = "Add Task")
            }
        }

    }
}