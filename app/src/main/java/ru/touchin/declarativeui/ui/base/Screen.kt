package ru.touchin.declarativeui.ui.base

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import ru.touchin.declarativeui.ui.theme.DeclarativeUITheme

@Composable
fun Screen(content: @Composable () -> Unit) {
    DeclarativeUITheme(darkTheme = false) {
        Surface(
            color = MaterialTheme.colors.background,
            modifier = Modifier
                .fillMaxWidth(1f)
                .fillMaxHeight(1f),
            content = content
        )
    }
}
