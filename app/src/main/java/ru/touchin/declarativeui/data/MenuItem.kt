package ru.touchin.declarativeui.data

import androidx.annotation.DrawableRes

data class MenuItem(
    @DrawableRes val imageRes: Int,
    val price: Int,
    val title: String,
    val description: String
)
