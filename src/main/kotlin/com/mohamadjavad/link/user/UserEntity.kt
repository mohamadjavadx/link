package com.mohamadjavad.link.user

import com.mohamadjavad.link.util.Empty
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
    val id: UUID = UUID.randomUUID(),

    @Column(
        nullable = false,
        updatable = false,
    )
    val email: String = String.Empty,

    @Column(nullable = true)
    val username: String? = null,
)

fun UserEntity.toDomain() = User(
    id = id,
    email = email,
    username = username
)