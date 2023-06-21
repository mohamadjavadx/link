package com.mohamadjavad.link.note

import jakarta.validation.constraints.NotNull
import java.util.*

class DeleteNoteRequest(

    @field:NotNull
    val id: UUID = UUID.randomUUID()
) : BaseNoteRequest()