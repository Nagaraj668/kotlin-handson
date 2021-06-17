package com.workouts.kotlinhandson.kotlin

import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class FlowExample {


}


fun simple(): Flow<Int> = flow { // flow builder
    for (i in 1..10) {
        delay(100) // pretend we are doing something useful here
        emit(i) // emit next value
    }
}

@InternalCoroutinesApi
fun main() = runBlocking {

    launch {
        for (k in 1..10) {
            println("I'm not blocked $k")
            delay(100)
        }
    }

    // Collect the flow
    simple().collect { println(it) }

    listOf(1, 2, 3, 4, 5).filter { it < 4 }.asFlow().collect {
        Thread.sleep(100)
        println(it)
    }
}