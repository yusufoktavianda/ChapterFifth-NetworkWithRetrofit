package binar.academy.networkingsample.request

data class RegisterRequest (
    val email: String,
    val password: String,
    val role: String
    )