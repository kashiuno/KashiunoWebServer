package com.kashiuno

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

suspend fun main(args: Array<String>) = coroutineScope<Unit> {
    launch {
        println("Создать сокет, обработать входные параметры")
        while (true) {
            delay(50L)
            doWork()
        }
    }
}

suspend fun doWork() {
    delay(5000)
    println("Прием подключений")
}
