package io.vertx.example.services

import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.delay
import kotlin.coroutines.experimental.suspendCoroutine

data class User(
        val id: Long,
        val name: String
)

interface UserService {
    suspend fun findUserById(id: Long): User
}

class UserServiceImpl : UserService {
    override suspend fun findUserById(id: Long): User {
        return suspendCoroutine { continuation ->
            async {
                delay(10)
                continuation.resume(User(id = id, name = "someone-$id"))
            }
        }
    }
}
