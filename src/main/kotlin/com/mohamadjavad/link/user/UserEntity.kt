package com.mohamadjavad.link.user

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import org.hibernate.annotations.GenericGenerator
import java.util.*

@Entity
data class UserEntity(
    @Id
    @Column(
        nullable = false,
        updatable = false,
    )
    @GenericGenerator(
        name = "UUID",
        strategy = "org.hibernate.id.UUIDGenerator"
    )
    @GeneratedValue(generator = "UUID")
    val id: UUID? = null,

    @Column(
        nullable = false,
        updatable = false,
        unique = true,
    )
    val email: String? = null,

    @Column(
        nullable = true,
        updatable = true,
    )
    val username: String? = null,
)

fun UserEntity.toDomain(): User {
    return User(
        id = id!!,
        email = email!!,
        username = username
    )
}