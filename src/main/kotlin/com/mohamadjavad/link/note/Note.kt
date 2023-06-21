package com.mohamadjavad.link.note

import java.util.*

class Note(
    val id: UUID,
    val ownerId: UUID,
    val title: String,
    val content: String,
)