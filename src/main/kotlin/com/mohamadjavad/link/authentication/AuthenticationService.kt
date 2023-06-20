package com.mohamadjavad.link.authentication

import com.mohamadjavad.link.email.EmailService
import com.mohamadjavad.link.user.User
import com.mohamadjavad.link.user.UserService
import com.mohamadjavad.link.util.NotAuthorizedException
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import kotlin.jvm.optionals.getOrElse

@OptIn(ExperimentalStdlibApi::class)
@Service
class AuthenticationService(
    private val userService: UserService,
    private val authenticationRepository: AuthenticationRepository,
    private val mailSender: EmailService,
) {
    companion object {
        private const val MaximumAllowedLoginAttempts = 3
        const val OtpCodeLength = 6
    }

    fun requestVerificationCode(requestVerificationCodeRequest: RequestVerificationCodeRequest) {
        authenticationRepository.deleteById(requestVerificationCodeRequest.email)
        authenticationRepository.save(
            AuthenticationEntity(
                email = requestVerificationCodeRequest.email,
                code = generateRandomCode(OtpCodeLength),
                attempts = 0,
                creationTime = LocalDateTime.now()
            )
        ).also { authenticationEntity ->
            mailSender.sendAuthenticationEmail(
                authenticationEntity.email,
                authenticationEntity.code,
            )
        }
    }

    fun finalizeAuthentication(finalizeAuthenticationRequest: FinalizeAuthenticationRequest): User {
        val email = finalizeAuthenticationRequest.email
        val code = finalizeAuthenticationRequest.code
        val authenticationEntity = authenticationRepository.findById(email).getOrElse {
            throw NotAuthorizedException()
        }
        return when {
            authenticationEntity.attempts >= MaximumAllowedLoginAttempts -> {
                authenticationRepository.delete(authenticationEntity)
                throw NotAuthorizedException()
            }

            authenticationEntity.code != code -> {
                authenticationRepository.save(
                    authenticationEntity.copy(
                        attempts = authenticationEntity.attempts + 1
                    )
                )
                throw NotAuthorizedException("enter correct code")
            }

            authenticationEntity.code == code -> {
                authenticationRepository.delete(authenticationEntity)
                userService.findUserByEmail(email) ?: userService.createUser(email)
            }

            else -> throw NotAuthorizedException("unknown error")
        }
    }


}