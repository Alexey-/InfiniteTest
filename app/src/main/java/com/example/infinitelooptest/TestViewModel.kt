package com.example.infinitelooptest

import kotlinx.coroutines.*

class TestViewModel(
    val dispatcher: CoroutineDispatcher
) : CoroutineScope {

    override val coroutineContext = dispatcher

    var interval: Job? = null

    var count = 0

    fun onStart() {
        interval = launch {
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
