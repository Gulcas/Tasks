package com.rafal.tasks.model

import androidx.compose.ui.graphics.Color
import java.io.Serializable
import java.util.UUID

data class Task(
    val title: String,
    val description: String,
    val colorType: ColorType,
    val id: String = UUID.randomUUID().toString()
) : Serializable //serializable pozwala na przesyłanie obiektu między activity

enum class ColorType(val color: Color) {
    CYAN(Color.Cyan),
    YELLOW(Color.Yellow),
    MAGENTA(Color.Magenta)
}
