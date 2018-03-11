package io.vertx.example.exceptions

class KExpressException(val status: Int, val errorCode: String, override val message: String) : Throwable(message)