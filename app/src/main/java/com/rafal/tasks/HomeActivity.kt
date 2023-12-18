package com.rafal.tasks

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val welcomeValue: String? = intent.getStringExtra("welcome_value")

        setContent {
            HomeText(welcomeValue)
        }
    }
    @Composable
    fun HomeText(txt: String?) {
        Text(text =  txt ?: "HomeActivity") //odbieramy wartość z intentu lub domyślną
    }
}