package com.mohamadjavad.link.authentication

import com.mohamadjavad.link.util.Empty
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import java.time.LocalDateTime

@Entity
data class AuthenticationEntity(
    @Id
    @Column(
        nullable = false,
        updatable = false,
        unique = true,
    )
    val email: String = String.Empty,

    @Column(
        nullable = false,
        updatable = false,
    )
    val code: String= String.Empty,

    @Column(
        nullable = false,
    )
    var attempts: Int = 0,

    @Column(
        nullable = false,
        updatable = false,
    )
    val creationTime: LocalDateTime = LocalDateTime.now(),
)