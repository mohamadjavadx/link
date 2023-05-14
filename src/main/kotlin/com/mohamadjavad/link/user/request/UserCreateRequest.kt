package com.mohamadjavad.link.user.request

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.Max
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotBlank

class UserCreateRequest(

    @field:NotBlank
    @field:Email
    val email: String,

    @field:Min(4)
    @field:Max(16)
    val username: String?,
)