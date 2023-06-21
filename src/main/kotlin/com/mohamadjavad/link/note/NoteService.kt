package com.mohamadjavad.link.note

import com.mohamadjavad.link.user.UserRepository
import com.mohamadjavad.link.user.UserService
import com.mohamadjavad.link.util.NotAuthorizedException
import org.springframework.stereotype.Service
import java.util.*
import kotlin.jvm.optionals.getOrElse

@OptIn(ExperimentalStdlibApi::class)
@Service
class NoteService(
    private val userService: UserService,
    private val userRepository: UserRepository,
    private val noteRepository: NoteRepository,
) {

    fun getAllNotes(getAllNotesRequest: GetAllNotesRequest): List<NoteDto> {
        return userService.getUserById(getAllNotesRequest.userId).notes.map(Note::toDto)
    }

    fun insert(insertNoteRequest: InsertNoteRequest): NoteDto {
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

        return noteEntity.toDto()
    }

    fun update(updateNoteRequest: UpdateNoteRequest): NoteDto {
        val user = userRepository.findById(updateNoteRequest.userId).getOrElse {
            throw NotAuthorizedException()
        }

        val noteEntity = noteRepository.save(
            NoteEntity(
                id = updateNoteRequest.id,
                owner = user,
                title = updateNoteRequest.title,
                content = updateNoteRequest.content
            )
        )

        return noteEntity.toDto()
    }

    fun delete(deleteNoteRequest: DeleteNoteRequest): UUID {
        userRepository.findById(deleteNoteRequest.userId).getOrElse {
            throw NotAuthorizedException()
        }

        noteRepository.deleteById(deleteNoteRequest.id)

        return deleteNoteRequest.id
    }

}