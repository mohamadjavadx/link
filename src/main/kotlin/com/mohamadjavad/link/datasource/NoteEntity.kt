package com.mohamadjavad.link.datasource

import com.mohamadjavad.link.note.Note
import jakarta.persistence.*
import org.hibernate.annotations.GenericGenerator
import java.util.*

@Entity
data class NoteEntity(
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id")
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

fun NoteEntity.toDomain(): Note = Note(
    id = id!!,
    owner = lazy { owner!!.toDomain() },
    title = title!!,
    content = content!!,
)