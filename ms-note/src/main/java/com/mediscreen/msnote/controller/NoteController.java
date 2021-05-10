package com.mediscreen.msnote.controller;

import com.mediscreen.msnote.model.NoteModel;
import com.mediscreen.msnote.service.NoteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.OptionalLong;

/**
 * Controller for handling note CRUD
 */
@RestController
@RequestMapping("/note")
public class NoteController {
    NoteService noteService;

    NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    /**
     * Endpoint: /note/list
     * Desc: Get all notes
     *
     * @param patientId patient id
     * @return list of patient
     */
    @GetMapping("/list")
    public List<NoteModel> getNotes(@RequestParam(required = false) Long patientId) {
        return this.noteService.getAll(patientId);
    }

    /**
     * Endpoint: /note/{id}
     * Desc: Get specific note
     *
     * @param id note tid
     * @return a specific note
     */
    @GetMapping("/{id}")
    public NoteModel getNote(@PathVariable Long id) {
        return this.noteService.getById(id);
    }
}
