package com.mohamadjavad.link.note

import jakarta.validation.constraints.NotNull
import java.util.*

open class BaseNoteRequest(

    @field:NotNull
    val userId: UUID = UUID.randomUUID()
)