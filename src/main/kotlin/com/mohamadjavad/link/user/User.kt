package com.mohamadjavad.link.user

import com.mohamadjavad.link.note.Note
import java.util.*

class User(
    val id: UUID,
    val email: String,
    val notes: List<Note>,
)