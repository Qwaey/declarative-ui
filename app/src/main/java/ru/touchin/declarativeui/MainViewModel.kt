package ru.touchin.declarativeui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.touchin.declarativeui.data.MenuItem
import ru.touchin.declarativeui.data.State
import kotlin.random.Random

class MainViewModel : ViewModel() {

    private val _state = MutableLiveData(State.LOADING)
    val state = _state as LiveData<State>

    private val _items = MutableLiveData<List<MenuItem>>()
    val items = _items as LiveData<List<MenuItem>>

    private val mockImageRes = listOf(
        R.drawable.ic_cat_1,
        R.drawable.ic_cat_2,
        R.drawable.ic_cat_3,
        R.drawable.ic_cat_4,
        R.drawable.ic_cat_5,
        R.drawable.ic_cat_6,
        R.drawable.ic_cat_7,
        R.drawable.ic_cat_8
    )

    init {
        val mockItems = mutableListOf<MenuItem>()
        for (i in 0 until 1000) {
            mockItems.add(
                MenuItem(
                    imageRes = mockImageRes[i % mockImageRes.size],
                    price = Random.nextInt(100, 1000),
                    title = "Котик №$i",
                    description = "Очень хороший котик"
                )
            )
        }
        _items.postValue(mockItems)
        _state.postValue(State.SUCCESS)
    }
}
