package ru.touchin.declarativeui.ui.screens.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import ru.touchin.declarativeui.MainViewModel
import ru.touchin.declarativeui.data.MenuItem
import ru.touchin.declarativeui.ui.base.Screen
import ru.touchin.declarativeui.ui.theme.Typography

@Composable
@Preview(showBackground = true)
fun MainScreen(viewModel: MainViewModel = viewModel()) = Screen {
    val items by viewModel.items.observeAsState()
    RecyclerView(items = items.orEmpty())
}

@Composable
fun RecyclerView(items: List<MenuItem>, modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier
            .fillMaxWidth(1f)
            .padding(horizontal = 12.dp)
    ) {
        items(items = items) { item ->
            Item(item = item)
        }
    }
}

@Composable
fun Item(item: MenuItem) {
    val counter = remember { mutableStateOf(0) }
    Spacer(modifier = Modifier.height(6.dp))
    Card(backgroundColor = Color.LightGray) {
        Row(modifier = Modifier.fillMaxWidth(1f)) {
            Image(
                painter = painterResource(id = item.imageRes),
                contentScale = ContentScale.Crop,
                contentDescription = "image",
                modifier = Modifier
                    .width(120.dp)
                    .aspectRatio(1f)
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth(1f)
                    .padding(12.dp)
                    .height(120.dp)
            ) {
                Text(text = item.title, style = Typography.h1)
                Text(text = item.description, style = Typography.body1)
                Row {
                    Button(
                        onClick = { counter.value-- },
                        modifier = Modifier.weight(0.5f)
                    ) {
                        Text(counter.value.toString())
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    Button(
                        onClick = { counter.value++ },
                        modifier = Modifier.weight(0.5f)
                    ) {
                        Text(counter.value.toString())
                    }
                }
            }
        }
    }
    Spacer(modifier = Modifier.height(6.dp))
}

@Composable
fun Screen() {
    Column {
        Row {
            Text("Hello world!")
            Button(onClick = { /*click action*/ }) {
                Text(text = "Button1")
            }
        }
        Button(onClick = { /*click action*/ }) {
            Text(text = "Button2")
        }
    }
}
