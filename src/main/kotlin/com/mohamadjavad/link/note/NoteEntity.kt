package com.mohamadjavad.link.note

import com.fasterxml.jackson.annotation.JsonIgnore
import com.mohamadjavad.link.user.UserEntity
import com.mohamadjavad.link.user.toDomain
import jakarta.persistence.*
import org.hibernate.annotations.GenericGenerator
import java.util.*

@Entity
data class NoteEntity(
    @Id
    @Column(
        nullable = false,
        updatable = false,
        unique = true,
    )
    @GenericGenerator(
        name = "UUID",
        strategy = "org.hibernate.id.UUIDGenerator"
    )
    @GeneratedValue(generator = "UUID")
    val id: UUID? = null,

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(
        nullable = false,
        updatable = false,
    )
    val owner: UserEntity? = null,

    @Column(
        nullable = false,
    )
    val title: String? = null,

    @Column(
        nullable = false,
    )
    val content: String? = null,
)

fun NoteEntity.toDomain(): Note {
    return Note(
        id = id!!,
        ownerId = owner!!.id!!,
        title = title!!,
        content = content!!,
    )
}