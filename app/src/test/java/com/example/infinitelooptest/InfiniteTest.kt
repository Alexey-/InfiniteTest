package com.example.infinitelooptest

import kotlinx.coroutines.delay
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.runTest
import org.junit.Test

import org.junit.Assert.*

class InfiniteTest {

    val scope = TestScope()
    val injectedDispatcher = StandardTestDispatcher(scope.testScheduler)

    @Test
    fun interval() = scope.runTest {
        val viewModel = TestViewModel(injectedDispatcher)
        viewModel.onStart()
        delay(30000) // <- execution will get stuck at this point
        assertEquals(6, viewModel.count)
        viewModel.onStop()
    }

    @Test
    fun androidInterval() = scope.runTest {
        val viewModel = AndroidTestViewModel(injectedDispatcher)
        viewModel.onStart()
        delay(30000) // <- execution will get stuck at this point
        assertEquals(6, viewModel.count)
        viewModel.onStop()
    }

}
