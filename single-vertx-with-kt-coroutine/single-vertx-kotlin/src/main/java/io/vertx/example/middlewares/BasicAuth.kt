package io.vertx.example.middlewares

import io.vertx.core.json.Json
import io.vertx.core.logging.Logger
import io.vertx.example.foundation.KRouter
import io.vertx.example.foundation.Loggable
import io.vertx.example.foundation.Middleware

class BasicAuth : KRouter(), Middleware, Loggable {
    override val logger: Logger = createLogger()

    init {
        route().handleCoroutine { req, res, next ->
            if(req.headers()["Basic"] == "testing") {
                next()
            } else {
                logger.info("unauthorized access")
                res.setStatusCode(401).end(Json.encode(mapOf("message" to "unauthorized")))
            }
        }
    }
}