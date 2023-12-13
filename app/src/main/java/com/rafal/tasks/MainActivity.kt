package com.rafal.tasks

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rafal.tasks.ui.theme.TasksTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            MyColumn()
//            MyRow()
//            MyModifier()
//            MyModifierExcercise()
//            MyText()
//            MyTextAlign()
//            MyIcon()
//            MySpacer()
//            MyDivider()
//            MyProgress()
//            MyViewExercise()
//            MyButton()
            MySurface()
        }
    }

    @Composable
    fun MySurface() {
        Surface(
            contentColor = Color.Blue, //kolor tekstu
            color = Color.Green, //kolor tła
            border = BorderStroke(2.dp, Color.DarkGray),
            shape = RoundedCornerShape(10.dp)
        ) {
            Text(
                text = "Siemandero",
                modifier = Modifier
                    .padding(10.dp)
            )
        }
    }


    @Composable
    fun MyButton() {
        Column() {
            Button(
                onClick = {}
            ) {
                Text(text = "Klikadełko")
            }

            Button(
                onClick = {},
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.LightGray,
                    contentColor = Color.DarkGray
                ),
                shape = RoundedCornerShape(10.dp),
                border = BorderStroke(1.dp, Color.DarkGray),
                contentPadding = PaddingValues(30.dp), //padding wewnątrz przycisku
                modifier = Modifier
                    .padding(10.dp), //margines przy krawędziach
                enabled = false
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(imageVector = Icons.Default.Add, contentDescription = null)
                    Text(text = "Dodaj")
                }
            }

            OutlinedButton(onClick = {}) {
                Text(text = "Klikadełko")
            }
            TextButton(onClick = {}) {
                Text(text = "Klikadełko")
            }
        }
    }

    @Composable
    fun MyViewExercise() {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Siemandero",
                color = Color.White,
                fontSize = 50.sp,
                fontWeight = FontWeight.Thin,
                textAlign = TextAlign.End,
                modifier = Modifier
                    .background(Color.Gray)
                    .fillMaxWidth()

            )
            Divider()
            CircularProgressIndicator(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
            )
            Divider()
            Text(
                text = "Progress bar",
                color = Color.Blue,
                fontWeight = FontWeight.Bold
            )
        }
    }

    @Composable
    fun MyProgress() {
        Column(
            modifier = Modifier
                .padding(10.dp)
        ) {
            CircularProgressIndicator(color = Color.Green)
            CircularProgressIndicator(progress = 0.8f, color = Color.Red)
            LinearProgressIndicator(
                color = Color.Green,
                modifier = Modifier
                    .fillMaxWidth(),
                trackColor = Color.Red
            )
            Spacer(modifier = Modifier.height(5.dp))
            LinearProgressIndicator(
                progress = 0.8f,
                color = Color.Red,
                modifier = Modifier
                    .fillMaxWidth()
            )
        }
    }

    @Composable
    fun MyDivider() {
        Column {
            Text(text = "Text 1")
            Divider(
                color = Color.Red,
                thickness = 5.dp,
            )
            Text(text = "Text 2")
        }
    }

    @Composable
    fun MySpacer() {
        Column {
            Text(
                text = "Text 1",
                modifier = Modifier
                    .padding(
//                        bottom = 20.dp
                    )
            )
            Spacer(
                modifier = Modifier
                    .height(20.dp)
                    .fillMaxWidth()
                    .background(Color.Gray)
            )
            Text(text = "Text 2")
        }
    }

    @Composable
    fun MyIcon() {
        Column() {
            Icon(imageVector = Icons.Default.Email, contentDescription = "Email")
            Icon(imageVector = Icons.Outlined.Email, contentDescription = "Email2")
            Icon(imageVector = Icons.Default.Done, contentDescription = "Done", tint = Color.Green)
            Icon(
                imageVector = Icons.Default.Done,
                contentDescription = "Done",
                tint = Color.White,
                modifier = Modifier
                    .background(Color.Green, CircleShape)
                    .border(1.dp, Color.Gray, CircleShape)
                    .padding(4.dp)
            )
        }
    }

    @Composable
    fun MyTextAlign() {
        Column(
            modifier = Modifier.fillMaxSize(),
//            horizontalAlignment = Alignment.End
        ) {
            Text(
                text = "Text 1",
                modifier = Modifier
                    .background(Color.Green)
                    .align(Alignment.End)
                    .fillMaxWidth(),
                textAlign = TextAlign.End
            )
            Text(
                text = "Text 2",
                modifier = Modifier
                    .background(Color.Yellow)
                    .align(Alignment.CenterHorizontally)
            )

            Text(
                text = "Text 3",
                modifier = Modifier
                    .background(Color.Red)
                    .align(Alignment.Start)
                    .fillMaxWidth()
                    .height(50.dp)
                    .wrapContentSize()
            )
        }
    }

    @Composable
    fun MyText() {
        Text(
            text = "Jakiś tam tekst do przetworzenia do zapisania w kilku lub jednej linii",
            fontSize = 20.sp,
            color = Color.Red,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Italic,
            textDecoration = TextDecoration.Underline,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.background(Color.Yellow)
        )

    }

    @Composable
    fun MyModifierExcercise() {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.DarkGray),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "TOP",
                modifier = Modifier
                    .padding(5.dp)
                    .background(Color.LightGray)
            )
            Text(
                text = "Bottom",
                modifier = Modifier
                    .border(2.dp, Color.White, RoundedCornerShape(10.dp))
                    .background(Color.LightGray, CircleShape)
                    .padding(5.dp)
            )
        }
    }

    @Composable
    fun MyModifier() {
        Column(
            modifier = Modifier
                .background(Color.LightGray)
                .fillMaxSize()
                .padding(vertical = 10.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
//                .padding(top = 10.dp, bottom = 10.dp, start = 10.dp, end = 50.dp)
//                .padding(50.dp)
//                .height(200.dp)
//                .width(200.dp)
//                .size(height = 100.dp, width = 100.dp)
        ) {
            Text(
                text = "Test modifiera",
                modifier = Modifier
                    .width(75.dp)
                    .background(Color.Cyan)
                    .padding(8.dp)
                    .rotate(45f)
                    .border(2.dp, Color.Black, RoundedCornerShape(5.dp))
//                    .clip(CircleShape) //przycięcie tekstu do kształtu
            )
            Text(
                text = "Dowolny text modifier",
                modifier = Modifier
                    .border(1.dp, Color.Black, RoundedCornerShape(5.dp))
                    .background(Color.Red)
                    .padding(10.dp)
                    .background(Color.Green)
                    .padding(5.dp)
                    .background(Color.DarkGray)
                    .rotate(30f)
                    .border(1.dp, Color.Black, CircleShape)
            )

        }
    }

    @Composable
    fun MyRow() {
        Row(
            modifier = Modifier
                .background(Color.DarkGray),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Text(text = "Bajlando")
            Text(text = "Bajlando 2")
            Text(text = "Bajlando 3")
        }
    }

    @Composable
    fun MyColumn() { // funkcja komponująca (Compose function) - zwraca komponent UI
        Column(
            modifier = Modifier
                .background(Color.LightGray)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "Bajlando")
            Text(text = "Bajlando 2")
            Text(text = "Bajlando 3")
        }
    }

    @Composable
    fun MyElement() {
    }
}
