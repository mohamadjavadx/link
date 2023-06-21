package com.mohamadjavad.link.note

import jakarta.validation.Valid
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/note")
@Validated
class NoteController(
    @Autowired
    private val noteService: NoteService
) {

    @GetMapping
    fun getAllNotes(
        @Valid
        @RequestBody
        getAllNotesRequest: GetAllNotesRequest,
    ): List<NoteDto> {
        return noteService.getAllNotes(getAllNotesRequest)
    }

    @PostMapping
    fun insert(
        @Valid
        @RequestBody
        insertNoteRequest: InsertNoteRequest,
    ): NoteDto {
        return noteService.insert(insertNoteRequest)
    }

    @PutMapping
    fun update(
        @Valid
        @RequestBody
        updateNoteRequest: UpdateNoteRequest,
    ): NoteDto {
        return noteService.update(updateNoteRequest)
    }

    @DeleteMapping
    fun delete(
        @Valid
        @RequestBody
        deleteNoteRequest: DeleteNoteRequest,
    ): UUID {
        return noteService.delete(deleteNoteRequest)
    }

}