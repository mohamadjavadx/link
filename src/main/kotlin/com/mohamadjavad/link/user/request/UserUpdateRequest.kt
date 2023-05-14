package com.mohamadjavad.link.user.request

import jakarta.validation.constraints.Max
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotBlank
import java.util.*

class UserUpdateRequest(

    @field:org.hibernate.validator.constraints.UUID
    val id: UUID,

    @field:NotBlank
    @field:Min(4)
    @field:Max(16)
    val username: String,
)