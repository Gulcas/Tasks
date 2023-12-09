package com.rafal.tasks

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
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
            MyText()
        }
    }

    @Composable
    fun MyText() {
        Text(
            text = "Jakiś tam tekst do przetworzenia",
            fontSize = 20.sp,
            color = Color.Red,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Italic
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
