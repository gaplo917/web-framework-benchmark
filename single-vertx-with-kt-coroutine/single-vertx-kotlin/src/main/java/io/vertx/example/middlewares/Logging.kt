package io.vertx.example.middlewares

import io.vertx.core.logging.Logger
import io.vertx.example.foundation.KRouter
import io.vertx.example.foundation.Loggable
import io.vertx.example.foundation.Middleware

class Logging : KRouter(), Loggable, Middleware {
    override val logger: Logger = createLogger()

    init {
        route().handleCoroutine { req, _, next ->
            logger.info(req.path())
            next()
        }
    }
}