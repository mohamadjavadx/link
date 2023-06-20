package com.mohamadjavad.link.note

import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface NoteRepository : JpaRepository<NoteEntity, UUID>