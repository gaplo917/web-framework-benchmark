package io.vertx.example.foundation

import io.vertx.core.logging.Log4j2LogDelegateFactory
import io.vertx.core.logging.Logger

interface Loggable {
    val logger: Logger
    fun createLogger(): Logger {
        return Logger(Log4j2LogDelegateFactory().createDelegate(this::class.java.name))
    }
}