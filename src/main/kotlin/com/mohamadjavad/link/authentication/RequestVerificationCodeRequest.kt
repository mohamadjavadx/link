package com.mohamadjavad.link.authentication

import com.mohamadjavad.link.util.Empty
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank

class RequestVerificationCodeRequest(

    @field:NotBlank
    @field:Email
    val email: String = String.Empty,
)