package io.vertx.example.foundation

import io.vertx.core.http.HttpServerRequest
import io.vertx.core.http.HttpServerResponse
import io.vertx.core.json.Json
import io.vertx.example.foundation.KExpress.Companion.dispatcher
import io.vertx.example.foundation.KExpress.Companion.vertx
import io.vertx.ext.web.Route
import io.vertx.ext.web.Router
import io.vertx.ext.web.RoutingContext
import kotlinx.coroutines.experimental.launch

abstract class KRouter : Router by Router.router(vertx) {
    fun <T> Route.handleCoroutine(f: suspend (RoutingContext) -> T): Route {
        return this.handler { req ->
            launch(dispatcher) {
                try {
                    f(req)
                } catch (e: Throwable) {
                    e.printStackTrace()

                    KExpress.globalErrorHandler?.handle(req)

                    if (!req.response().ended()) {
                        req.response().end()
                    }
                }
            }
        }
    }

    fun <T> Route.handleCoroutine(f: suspend (HttpServerRequest, HttpServerResponse) -> T): Route {
        return this.handleCoroutine { req -> f(req.request(), req.response()) }
    }

    fun <T> Route.handleCoroutine(f: suspend (HttpServerRequest, HttpServerResponse, () -> Unit) -> T): Route {
        return this.handleCoroutine { req -> f(req.request(), req.response(), req::next) }
    }

    fun <T> Route.json(f: suspend (RoutingContext) -> T): Route {
        return this.handleCoroutine { req ->
            req.response().putHeader("Content-Type", "application/json").end(Json.encode(f(req)))
        }
    }

    fun <T> Route.json(f: suspend (HttpServerRequest, HttpServerResponse) -> T): Route {
        return this.json { req -> f(req.request(), req.response()) }
    }

    fun <T> Route.json(f: suspend (HttpServerRequest, HttpServerResponse, () -> Unit) -> T): Route {
        return this.json { req -> f(req.request(), req.response(), req::next) }
    }
}