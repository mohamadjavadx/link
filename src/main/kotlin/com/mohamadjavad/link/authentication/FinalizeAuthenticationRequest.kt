package com.mohamadjavad.link.authentication

import com.mohamadjavad.link.authentication.AuthenticationService.Companion.OtpCodeLength
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Pattern

class FinalizeAuthenticationRequest(

    @field:NotBlank
    @field:Email
    val email: String,

    @field:NotBlank
    @field:Pattern(regexp = "^[0-9]{$OtpCodeLength}$")
    val code: String
)