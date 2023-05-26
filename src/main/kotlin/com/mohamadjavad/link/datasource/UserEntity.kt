package com.mohamadjavad.link.datasource

import com.mohamadjavad.link.user.User
import jakarta.persistence.*
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
        nullable = false,
        updatable = true,
    )
    val username: String? = null,

    @OneToMany(
        mappedBy = "owner",
        cascade = [CascadeType.ALL],
        fetch = FetchType.LAZY
    )
    @Column(
        nullable = false,
        updatable = true,
    )
    val notes: MutableList<NoteEntity>? = null
)

fun UserEntity.toDomain(): User = User(
    id = id!!,
    email = email!!,
    username = username,
    notes = lazy { notes!!.map(NoteEntity::toDomain) }
)