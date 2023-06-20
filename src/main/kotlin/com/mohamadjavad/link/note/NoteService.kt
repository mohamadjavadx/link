package com.mohamadjavad.link.note

import com.mohamadjavad.link.user.UserEntity
import com.mohamadjavad.link.user.UserRepository
import com.mohamadjavad.link.user.UserService
import com.mohamadjavad.link.util.NotAuthorizedException
import org.springframework.stereotype.Service
import kotlin.jvm.optionals.getOrElse

@Service
class NoteService(
    private val userService: UserService,
    private val userRepository: UserRepository,
    private val noteRepository: NoteRepository,
) {

    fun getAllNotesByUser(getAllNotesRequest: GetAllNotesRequest): List<Note> {
        return userService.getUserById(getAllNotesRequest.userId).notes
    }

    @OptIn(ExperimentalStdlibApi::class)
    fun insert(insertNoteRequest: InsertNoteRequest): Note {
        val user = userRepository.findById(insertNoteRequest.userId).getOrElse {
            throw NotAuthorizedException()
        }

        val noteEntity = noteRepository.save(
            NoteEntity(
                owner = user,
                title = insertNoteRequest.title,
                content = insertNoteRequest.content
            )
        )

        return noteEntity.toDomain()
    }

}