package com.mohamadjavad.link.authentication

import jakarta.validation.Valid
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/authenticate")
@Validated
class AuthenticationController(
    @Autowired
    private val authenticationService: AuthenticationService
) {

    @PostMapping("/request-verification-code")
    fun authenticate(
        @Valid
        @RequestBody
        requestVerificationCodeRequest: RequestVerificationCodeRequest
    ): String {
        return runCatching {
            authenticationService.requestVerificationCode(requestVerificationCodeRequest)
            "check your mail"
        }.getOrElse {
            "failed"
        }
    }

    @PostMapping("/finalize-authentication")
    fun login(
        @Valid
        @RequestBody
        finalizeAuthenticationRequest: FinalizeAuthenticationRequest
    ): FinalizeAuthenticationResponse {
        val user = authenticationService.finalizeAuthentication(finalizeAuthenticationRequest)
        // TODO: use jwt token
        return FinalizeAuthenticationResponse(userId = user.id)
    }

}