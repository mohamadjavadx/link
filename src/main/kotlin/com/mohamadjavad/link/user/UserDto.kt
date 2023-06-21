package com.mohamadjavad.link.user

import com.mohamadjavad.link.note.Note
import com.mohamadjavad.link.note.NoteDto
import com.mohamadjavad.link.note.toDto
import java.util.*

class UserDto(
    val id: UUID,
    val email: String,
    val notes: List<NoteDto>,
)

fun User.toDto() = UserDto(
    id = id,
    email = email,
    notes = notes.map(Note::toDto)
)