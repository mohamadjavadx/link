package com.mohamadjavad.link.note

import jakarta.validation.constraints.NotBlank

class InsertNoteRequest(

    @field:NotBlank
    val title: String,

    @field:NotBlank
    val content: String,
) : BaseNoteRequest()