package com.mohamadjavad.link.user

import java.util.*

data class User(
    val id: UUID,
    val email: String,
    val username: String?,
)