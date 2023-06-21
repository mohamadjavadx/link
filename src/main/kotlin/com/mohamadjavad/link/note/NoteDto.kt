package com.mohamadjavad.link.note

import java.util.*

class NoteDto(
    val id: UUID,
    val title: String,
    val content: String,
)

fun Note.toDto(): NoteDto = NoteDto(
    id = id,
    title = title,
    content = content
)