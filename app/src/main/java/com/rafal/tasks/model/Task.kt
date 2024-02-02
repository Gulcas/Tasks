package com.rafal.tasks.model

import androidx.compose.ui.graphics.Color
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.rafal.tasks.ui.theme.CardGreen
import com.rafal.tasks.ui.theme.CardRed
import com.rafal.tasks.ui.theme.CardYellow
import com.squareup.moshi.JsonClass
import java.io.Serializable
import java.util.UUID
@Entity
@JsonClass(generateAdapter = true) //generuje adapter do serializacji
data class Task(
    val title: String,
    val description: String,
    val colorType: ColorType,
    @PrimaryKey val id: String = UUID.randomUUID().toString()
) : Serializable //serializable pozwala na przesyłanie obiektu między activity

enum class ColorType(val color: Color) {
    CYAN(CardGreen),
    YELLOW(CardYellow),
    MAGENTA(CardRed)
}
