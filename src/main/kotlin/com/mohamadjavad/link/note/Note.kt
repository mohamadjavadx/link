package com.mohamadjavad.link.note

import com.mohamadjavad.link.user.User
import java.util.*

data class Note(
    val id: UUID,
    val owner: Lazy<User>,
    val title: String,
    val content: String,
)
