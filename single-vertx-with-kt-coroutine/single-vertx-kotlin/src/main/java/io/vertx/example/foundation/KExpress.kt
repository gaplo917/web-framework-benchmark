package io.vertx.example.foundation

import io.vertx.core.Vertx
import io.vertx.ext.web.Router
import io.vertx.ext.web.handler.ErrorHandler
import io.vertx.kotlin.coroutines.dispatcher
import kotlinx.coroutines.experimental.CoroutineDispatcher

open class KExpress : KRouter() {

    companion object {
        val vertx: Vertx = Vertx.vertx()
        val dispatcher: CoroutineDispatcher = vertx.dispatcher()
        var globalErrorHandler: ErrorHandler? = null
    }

    fun listen(port: Int) {
        vertx.createHttpServer()
                .requestHandler(::accept)
                .listen(port) { result ->
                    if (result.succeeded()) {
                        println("Server up and running")
                    } else {
                        println(result.cause())
                    }
                }
    }

    /**
     * express liked API
     */
    fun use(path: String, subRouter: Router) {
        mountSubRouter(path, subRouter)
    }

    fun use(path: String, vararg subRouters: Router) {
        subRouters.forEach {
            mountSubRouter(path, it)
        }
    }

    fun use(path: String, subRouters: List<Router>) {
        subRouters.forEach {
            mountSubRouter(path, it)
        }
    }

    fun use(middleware: Middleware) {
        mountSubRouter("/", middleware)
    }

    fun use(globalErrorHandler: ErrorHandler) {
        Companion.globalErrorHandler = globalErrorHandler
    }

}