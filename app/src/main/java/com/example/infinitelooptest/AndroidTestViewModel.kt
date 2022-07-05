package com.example.infinitelooptest

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.*

class AndroidTestViewModel(
    val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : ViewModel() {

    var interval: Job? = null

    var count = 0

    fun onStart() {
        interval = viewModelScope.launch(dispatcher) {
            while (true) {
                delay(5000)
                count++
            }
        }
    }

    fun onStop() {
        interval?.cancel()
    }

}
