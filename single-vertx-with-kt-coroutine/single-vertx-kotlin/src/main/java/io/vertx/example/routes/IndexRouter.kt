package io.vertx.example.routes

import io.vertx.example.foundation.KRouter
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch
import java.util.concurrent.CompletableFuture
import kotlin.coroutines.experimental.suspendCoroutine

class IndexRouter : KRouter() {
    init {
        get("/").handleCoroutine { req ->
            req.response().end("OK")
        }
        get("/2ms").handleCoroutine { req ->
            req.response().end(fakeIOOperation(2))
        }
        get("/5ms").handleCoroutine { req ->
            req.response().end(fakeIOOperation(5))
        }
        get("/10ms").handleCoroutine { req ->
            req.response().end(fakeIOOperation(10))
        }
    }

    suspend fun fakeIOOperation(duration: Long): String {
        return suspendCoroutine {
            launch {
                delay(duration)
                it.resume("OK")
            }
        }
    }
}
