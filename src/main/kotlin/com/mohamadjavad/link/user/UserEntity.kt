package com.mohamadjavad.link.user

import com.fasterxml.jackson.annotation.JsonIgnore
import com.mohamadjavad.link.note.NoteEntity
import com.mohamadjavad.link.note.toDomain
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

    @JsonIgnore
    @OneToMany(
        mappedBy = "owner",
        cascade = [CascadeType.ALL],
        fetch = FetchType.EAGER
    )
    @Column(
        nullable = true,
        updatable = true,
    )
    val notes: MutableList<NoteEntity>? = null,
)

fun UserEntity.toDomain(): User {
    return User(
        id = id!!,
        email = email!!,
        notes = notes?.map(NoteEntity::toDomain).orEmpty()
    )
}