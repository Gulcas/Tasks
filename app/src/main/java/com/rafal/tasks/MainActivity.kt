package com.rafal.tasks

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.CheckBox
import android.widget.RadioButton
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
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
//            MySurface(
//            MyCard()
//            MyBox()
//            MyLayoutWeight()
//            MyLayoutExercise()
//            MyClickButton()
//            MyButtonClick()
//            MyCheckBox()
//            MyRadioButton()
//            MySwitchButton()
//            MySlider()
//            MyIconButton()
//            MyFAB()
//            MyModifierClickable()
//            MyShowHide()
//            MyShowHideExercise()
//            MyTextField()
//            MyOutlinedTextField()
//            MyTextFieldExercise()
//            MyTextFieldExerciseCheckLength()
//            MyLazyColumn()
//            MyLazyRow()
//            MyLazyItem()
//            MyLazyVerticalGrid()
//            MyLazyHorizontalGrid()
//            MyLazyColumnButtonExercise()
//            MyLazyRowClickExercise()
//            MyLazyColumRowExercise()
//            MyLazyGridExercise()
//            MyHomeActivityView()
            MyActivityExercise()
        }
    }

    @Composable
    fun MyActivityExercise() {
        var text by remember { mutableStateOf("")
        }
        val context = LocalContext.current
        val intent = Intent(context, MyExerciseActivity::class.java)
        intent.putExtra("exercise_value", text)

        Column() {
            OutlinedTextField(
                value = text,
                onValueChange = { value ->
                    text = value
                },
                label = { Text(text = "Wpisz tekst") },
            )
            Button(onClick = { startActivity(intent) }) {
                Text(text = "Przejdź do MyExerciseActivity")
            }
        }

    }

    @Composable
    fun MyHomeActivityView() {
        val context: Context = LocalContext.current
        val intent: Intent = Intent(context, HomeActivity::class.java)
        intent.putExtra("welcome_value", "Przesłane z MainActivity")

        Button(onClick = { startActivity(intent) }) {
            Text(text = "Home Activity")
        }
    }

    @Composable
    fun MyLazyGridExercise() {
        var count by remember { mutableStateOf(3) }

        Column() {
            Row() {
                Button(onClick = { count = 1 }) {
                    Text(text = "1")
                }
                Button(onClick = { count = 2 }) {
                    Text(text = "2")
                }
                Button(onClick = { count = 5 }) {
                    Text(text = "5")
                }
            }

            LazyVerticalGrid(columns = GridCells.Fixed(count)) {
                items(count = 100) { index ->
                    MyLazyItemFunkcja(index)
                }
            }
        }
    }

    @Composable
    fun MyLazyColumRowExercise() {
        LazyColumn() {
            items(count = 100) { columnIndex ->
                LazyRow() {
                    items(count = 100) { rowIndex ->
                        MyLazyItemFunkcja(number = columnIndex * rowIndex)
                    }
                }
            }
        }
    }

    @Composable
    fun MyLazyRowClickExercise() {
        var selectedIndex by remember { mutableStateOf(-1) } //delegat by

        LazyRow() {
            items(count = 100) { index ->
                Surface(
                    border = BorderStroke(1.dp, Color.Black),
                    color = if (selectedIndex == index) Color.LightGray else Color.White,
                    modifier = Modifier
                        .clickable { selectedIndex = index }
                ) {
                    Text(text = "$index", modifier = Modifier.padding(10.dp))
                }
            }
        }
    }

    @Composable
    fun MyLazyColumnButtonExercise() {
        var counter by remember { mutableStateOf(0) } //delegat by
        val itemList = remember { mutableStateListOf<Int>() }

        Column() {
            Button(
                onClick = { itemList.add(counter++) }) { //dodanie elementu do listy po kliknięciu
                Text(text = "Add")
            }
            LazyColumn() {
                items(items = itemList) { item ->
                    Text(text = "Item $item")
                }
            }
        }
    }

    @Composable
    fun MyLazyHorizontalGrid() {
        LazyHorizontalGrid(
            rows = GridCells.Adaptive(minSize = 50.dp),
            contentPadding = PaddingValues(12.dp),
            horizontalArrangement = Arrangement.spacedBy(20.dp),
            verticalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            items(count = 100) { index ->
                MyLazyItemFunkcja(index)
            }
        }
    }

    @Composable
    fun MyLazyVerticalGrid() {
        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            contentPadding = PaddingValues(4.dp),
            horizontalArrangement = Arrangement.spacedBy(4.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            items(count = 100) { index ->
                MyLazyItemFunkcja(index)
            }
        }
    }

    @Composable
    fun MyLazyItem() {
        LazyRow(
            contentPadding = PaddingValues(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(count = 100) { index ->
                MyLazyItemFunkcja(index)
            }
        }
    }

    @Composable
    fun MyLazyItemFunkcja(number: Int) {
        Card(
            border = BorderStroke(1.dp, Color.Black),
        ) {
            Row(
                modifier = Modifier
                    .padding(4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(imageVector = Icons.Default.List, contentDescription = null)
                Text(text = "Item $number")
            }
        }
    }

    @Composable
    fun MyLazyRow() {

        val itemList = remember { mutableStateListOf("A", "B", "C", "D") }

        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(8.dp)
        ) {
            item { Text(text = "A") }
            items(count = 4) { index ->
                Text(text = "$index")
            }
            items(items = itemList) { item ->
                Text(text = "$item")
            }
        }
    }

    @Composable
    fun MyLazyColumn() {

        val itemList = remember { mutableStateListOf(1, 5, 9, 90, 22) }
        itemList.add(123) //dodanie elementu do listy

        var emptyList = remember { mutableStateListOf<Int>() }//pusta lista

        val itemListNonMutable = listOf(2, 4, 5, 4) //lista niezmienna

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(4.dp),
            contentPadding = PaddingValues(top = 4.dp, start = 10.dp),
        ) {
            item { Text(text = "Item A") }
            item { Text(text = "Item B") }

            for (i in 0..22) {
                item { Text(text = "for Item $i") }
            }

            items(count = 33) { index ->
                Text(text = "items Item $index")
            }

            items(items = itemList) { item ->
                Text(text = "itemsList items $item")
            }

        }
    }

    @Composable
    fun MyTextFieldExerciseCheckLength() {
        var text by remember { mutableStateOf("") }
        var isTextToLong by remember { mutableStateOf(false) }
        val maxChar = 10

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        ) {
            TextField(
                value = text,
                onValueChange = { value ->
                    text = value
                    isTextToLong = text.length > maxChar
                },
                modifier = Modifier
                    .fillMaxWidth(),
                isError = isTextToLong,
            )

            Box(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                if (isTextToLong) {
                    Text(
                        text = "Za długi tekst",
                        color = Color.Red,
                        modifier = Modifier
                            .align(Alignment.CenterStart)
                    )
                }
                Text(
                    text = "${text.length}/$maxChar",
                    modifier = Modifier
                        .align(Alignment.CenterEnd)
                )
            }
        }
    }

    @Composable
    fun MyTextFieldExercise() {
        var emailText by remember { mutableStateOf("") }
        var passwordText by remember { mutableStateOf("") }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        ) {
            OutlinedTextField(
                value = emailText,
                onValueChange = { emailText = it },
                modifier = Modifier
                    .fillMaxWidth(),
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Email,
                        contentDescription = null
                    )
                },
                label = { Text(text = "Email") },
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                isError = !android.util.Patterns.EMAIL_ADDRESS.matcher(emailText).matches(),
            )

            Spacer(
                modifier = Modifier
                    .height(20.dp)
            )

            OutlinedTextField(
                value = passwordText,
                onValueChange = { passwordText = it },
                modifier = Modifier
                    .fillMaxWidth(),
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Lock,
                        contentDescription = null
                    )
                },
                label = { Text(text = "Password") },
                singleLine = true,
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                isError = passwordText.length < 6,
            )
        }
    }

    @Composable
    fun MyOutlinedTextField() {
        var text by remember { mutableStateOf("") }
        OutlinedTextField(
            value = text, onValueChange = { text = it },
            colors = OutlinedTextFieldDefaults.colors()
        )
    }

    @Composable
    fun MyTextField() {
        var text by remember { mutableStateOf("") }
        TextField(
            value = text,
            onValueChange = { text = it },
            label = {
                Text(text = "Wpisz tekst")
            },
            placeholder = {
                Text(text = "Tekst placeholder")
            },
            leadingIcon = {
                Icon(imageVector = Icons.Default.Lock, contentDescription = null)
            },
            trailingIcon = {
                Icon(imageVector = Icons.Default.Done, contentDescription = null)
            },
            isError = true,
            colors = TextFieldDefaults.colors(),
            textStyle = TextStyle(color = Color.Red),
//            singleLine = true,
            maxLines = 2,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            visualTransformation = PasswordVisualTransformation(),
        )
    }

    @Composable
    fun MyShowHideExercise() {
        var isSettingsShowed by remember { mutableStateOf(false) }
        var volumeValue by remember { mutableStateOf(0f) }
        Column() {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(
                    checked = isSettingsShowed,
                    onCheckedChange = { value -> isSettingsShowed = value },
                )
                Icon(
                    imageVector = Icons.Default.Settings,
                    contentDescription = "Settings Icon",
                )
                Text(text = "Ustawienia")
            }
            if (isSettingsShowed) {
                Column() {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = Icons.Outlined.Notifications,
                            contentDescription = "Min"
                        )
                        Slider(
                            value = volumeValue,
                            onValueChange = { volumeValue = it },
                            modifier = Modifier
                                .width(300.dp)
                        )
                        Icon(
                            imageVector = Icons.Filled.Notifications,
                            contentDescription = "Max",
                            tint = if (volumeValue > 0.8f) Color.Red else Color.Black
                        )
                    }
                    if (volumeValue > 0.8f) {
                        Text(text = "Uwaga, głośno!", color = Color.Red)
                    }
                }
            }
        }
    }

    @Composable
    fun MyShowHide() {
        var isShowed by remember { mutableStateOf(false) }

        Row() {
            Button(onClick = { isShowed = !isShowed }) {
                Text(text = if (isShowed) "Pokazany" else "Ukryty")
            }
            if (isShowed) {
                Text(text = "Ukryty tekst")
            }
        }
    }

    @Composable
    fun MyModifierClickable() {
        var isClicked by remember { mutableStateOf(false) }
        Text(
            text = if (isClicked) "Kliknięto" else "Nie kliknięto",
            modifier = Modifier
                .clickable { isClicked = !isClicked }
        )
    }

    @Composable
    fun MyFAB() {
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            FloatingActionButton(
                onClick = { },
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(16.dp)
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Add Icon")
            }
        }
    }

    @Composable
    fun MyIconButton() {
        var isFavorite by remember { mutableStateOf(false) }
        IconButton(onClick = { isFavorite = !isFavorite }) {
            Icon(
                imageVector = if (isFavorite) Icons.Filled.Favorite else Icons.Outlined.FavoriteBorder,
                contentDescription = "Favorite Icon",
                tint = Color.LightGray
            )
        }
    }

    @Composable
    fun MySlider() {
        var sliderValue by remember { mutableStateOf(0f) }
        Slider(
            value = sliderValue, onValueChange = { value -> sliderValue = value },
            modifier = Modifier.padding(horizontal = 40.dp),
            valueRange = 0f..100f,
            steps = 15, //ilość kroków, kropek na suwaku
            colors = SliderDefaults.colors(
                activeTickColor = Color.Green,
                inactiveTickColor = Color.Red,
                thumbColor = Color.Black,
                activeTrackColor = Color.Yellow,
                inactiveTrackColor = Color.LightGray
            )
        )
        Text(text = "$sliderValue")
    }

    @Composable
    fun MySwitchButton() {
        var isChecked by remember { mutableStateOf(false) }
        Switch(
            checked = isChecked, onCheckedChange = { value -> isChecked = value },
            colors = SwitchDefaults.colors(
                checkedBorderColor = Color.Green,
                checkedThumbColor = Color.LightGray,
                checkedTrackColor = Color.Yellow,
                uncheckedBorderColor = Color.Black,
                uncheckedThumbColor = Color.DarkGray,
                uncheckedTrackColor = Color.Magenta
            )
        )
    }

    @Composable
    fun MyRadioButton() {
        var isSelected by remember { mutableStateOf(false) }
        RadioButton(
            selected = isSelected,
            onClick = { isSelected = !isSelected }, //lambda
            colors = RadioButtonDefaults.colors(
                selectedColor = Color.Green,
                unselectedColor = Color.Red
            )
        )
    }

    @Composable
    fun MyCheckBox() {
        var isChecked: Boolean by remember { mutableStateOf(false) }
        Checkbox(
            checked = isChecked,
            onCheckedChange = { value -> isChecked = value }, //lambda
            colors = CheckboxDefaults.colors(checkedColor = Color.Green, uncheckedColor = Color.Red)
        )
    }

    @Composable
    fun MyButtonClick() {
        var number: Int by remember { mutableStateOf(0) }
        Row() {
            Button(
                onClick = { number-- },
                modifier = Modifier
                    .size(30.dp),
                contentPadding = PaddingValues(2.dp),
                enabled = number > 0 //uproszczony if - jeśli warunek jest spełniony to przycisk jest aktywny
            ) {
                Text(text = "-")
            }
            Text(
                text = "$number",
                modifier = Modifier
                    .size(height = 30.dp, width = 50.dp)
                    .padding(horizontal = 4.dp)
                    .border(1.dp, Color.Gray)
                    .wrapContentSize()
            )
            Button(
                onClick = { number++ },
                modifier = Modifier
                    .size(30.dp),
                contentPadding = PaddingValues(2.dp)
            ) {
                Text(text = "+")
            }
        }
    }

    @Composable
    fun MyClickButton() {
        var countState: MutableState<Int> =
            remember { mutableStateOf(0) } //zapisanie stanu zmiennej
        var count: Int by remember { mutableStateOf(0) } //zapisanie stanu zmiennej poprzez delegat 'by'

        Column {
            Button(onClick = { countState.value++ }) {
                Text(text = "Klikadełko ${countState.value}")
            }
            Button(onClick = { count++ }) {
                Text(text = "Klikadełko versja druga $count")
            }
            MyInnerClickButton(countPar = count)
            MyInnerClickButtonMuttable(countPar = countState)
        }
    }

    @Composable
    fun MyInnerClickButton(countPar: Int) {
        Button(onClick = { /*countPar++ */ }) {
            Text(text = "Inner count $countPar")
        }
    }

    @Composable
    fun MyInnerClickButtonMuttable(countPar: MutableState<Int>) {
        Button(onClick = { countPar.value++ }) {
            Text(text = "Inner count state ${countPar.value}")
        }
    }


    @Composable
    fun MyLayoutExercise() {
        Box(
            contentAlignment = Alignment.BottomCenter,
            modifier = Modifier
                .fillMaxSize()
        ) {
            Row(
                modifier = Modifier
                    .background(Color.DarkGray)
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                MyLayoutInfoView(Modifier.weight(1f)) //przekazanie parametru do funkcji
                MyLayoutPriceView()
            }
        }
    }

    @Composable
    fun MyLayoutInfoView(modifier: Modifier) {
        Column(modifier = modifier) {
            Text(
                text = "Kurs Kotlin i jakiś tam tekst długiiiiiiiiii",
                color = Color.White,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(4.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "4.4",
                    color = Color.Yellow,
                )
                Spacer(modifier = Modifier.width(4.dp))
                Icon(
                    imageVector = Icons.Default.Star,
                    contentDescription = "Star Icon",
                    tint = Color.Yellow
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = "Ocen duźo",
                    color = Color.Magenta,
                    textDecoration = TextDecoration.Underline
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = "110 uczestników",
                    color = Color.White
                )
            }
        }
    }

    @Composable
    fun MyLayoutPriceView() {
        Row() {
            Column(
                horizontalAlignment = Alignment.End,
            ) {
                Text(
                    text = "44,99 zł",
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    fontSize = 20.sp
                )
                Text(
                    text = "244,99 zł",
                    color = Color.LightGray,
                    textDecoration = TextDecoration.LineThrough,
                    fontSize = 14.sp
                )
            }
            Spacer(modifier = Modifier.width(16.dp))
            Button(
                onClick = {},
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White,
                    contentColor = Color.Black
                ),
                shape = RoundedCornerShape(5.dp),
                contentPadding = PaddingValues(8.dp),
            ) {
                Text(
                    text = "Kup teraz",
                    fontWeight = FontWeight.ExtraBold
                )
            }
        }
    }

    @Composable
    fun MyLayoutWeight() {
        Row() {
            Text(
                text = "text 1",
                modifier = Modifier
                    .background(Color.Green)
                    .weight(1f)
            )
            Text(
                text = "text 2",
                modifier = Modifier
                    .background(Color.Yellow)
//                    .weight(1f)
            )
            Text(
                text = "text 3",
                modifier = Modifier
                    .background(Color.Red)
//                    .weight(1f)
            )

        }
    }

    @Composable
    fun MyBox() {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.LightGray),
//            contentAlignment = Alignment.TopEnd
        ) {
            Text(
                text = "Box",
                modifier = Modifier
                    .align(Alignment.TopCenter)
            )
            Text(
                text = "Box2",
                modifier = Modifier
                    .align(Alignment.TopStart)
            )
            Text(
                text = "Box3",
                modifier = Modifier
                    .align(Alignment.TopEnd)
            )
            Box(
                modifier = Modifier
                    .size(150.dp)
                    .border(1.dp, Color.Black, RoundedCornerShape(8.dp))
                    .align(Alignment.Center)
                    .padding(10.dp)
            ) {

                Spacer(
                    modifier = Modifier
                        .size(50.dp)
                        .background(Color.Green, RoundedCornerShape(8.dp))
                        .align(Alignment.TopStart)
                )
                Spacer(
                    modifier = Modifier
                        .size(70.dp)
                        .background(Color.Yellow, RoundedCornerShape(8.dp))
                        .align(Alignment.BottomEnd)
                )
                Spacer(
                    modifier = Modifier
                        .size(100.dp)
                        .background(Color.Red, RoundedCornerShape(8.dp))
                        .align(Alignment.Center)
                )
            }
        }
    }

    @Composable
    fun MyCard() {
        Card(
            modifier = Modifier
                .padding(20.dp),
            elevation = CardDefaults.elevatedCardElevation(defaultElevation = 10.dp),
            colors = CardDefaults.cardColors(Color.DarkGray)//cieniowanie
        ) {
            Text(
                text = "Card",
                modifier = Modifier
                    .padding(10.dp)
            )
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
