package com.kashiuno

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.net.InetSocketAddress
import java.nio.channels.SocketChannel

suspend fun main(args: Array<String>) = coroutineScope<Unit> {
    launch {
        val props = parseWebServerProperties(args)
        val sock = SocketChannel.open()
        sock.bind(InetSocketAddress(props.host, props.port))
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

private fun parseWebServerProperties(args: Array<String>): WebServerProperties {
    var name: String? = null
    var host = "0.0.0.0"
    var port = 8080
    for (a in args) {
        if (name != null) {
            when (name) {
                "port" -> {
                    port = Integer.parseInt(a)
                }

                "host" -> {
                    host = a
                }
            }
            name = null
            continue
        }
        if (a == "--host") {
            name = "host"
        }
        if (a == "--port") {
            name = "port"
        }
    }
    val props = WebServerProperties(host, port)
    return props
}
