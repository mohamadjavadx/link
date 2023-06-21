package com.mohamadjavad.link.note

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import java.util.*

class UpdateNoteRequest(

    @field:NotNull
    val id: UUID = UUID.randomUUID(),

    @field:NotBlank
    val title: String,

    @field:NotBlank
    val content: String,
) : BaseNoteRequest()