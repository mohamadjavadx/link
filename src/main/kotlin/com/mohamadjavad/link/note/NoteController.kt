package com.mohamadjavad.link.note

import jakarta.validation.Valid
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/note")
@Validated
class NoteController(
    @Autowired
    private val noteService: NoteService
) {

    @PostMapping("/all")
    fun getAllNotes(
        @Valid
        @RequestBody
        getAllNotesRequest: GetAllNotesRequest,
    ): List<Note> {
        return noteService.getAllNotesByUser(getAllNotesRequest)
    }

    @PostMapping
    fun insertOne(
        @Valid
        @RequestBody
        insertNoteRequest:InsertNoteRequest,
    ): Note{
        return noteService.insert(insertNoteRequest)
    }

}