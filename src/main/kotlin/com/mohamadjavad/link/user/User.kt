package com.mohamadjavad.link.user

import com.mohamadjavad.link.note.Note
import java.util.*

data class User(
    val id: UUID,
    val email: String,
    val username: String?,
    val notes: Lazy<List<Note>>,
)