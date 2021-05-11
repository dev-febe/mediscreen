package com.mediscreen.msnote.controller;

import com.mediscreen.msnote.entity.Note;
import com.mediscreen.msnote.model.NoteModel;
import com.mediscreen.msnote.service.NoteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
     * @param id note id
     * @return a specific note
     */
    @GetMapping("/{id}")
    public NoteModel getNote(@PathVariable Long id) {
        return this.noteService.getById(id);
    }

    /**
     * Endpoint: /note/add
     * Desc: Save note
     *
     * @param note note to save
     * @return note saved
     */
    @PostMapping("/add")
    public Note postNote(@RequestBody Note note) {
        return this.noteService.save(note);
    }

    /**
     * Endpoint: /note/add
     * Desc: Save note
     *
     * @param note note to update
     * @return note updated
     */
    @PostMapping("/update/{id}")
    public Note putPatient(@PathVariable long id, @RequestBody Note note) {
        return this.noteService.update(id, note);
    }

    /**
     * Endpoint: /note/delete/{id}
     * Desc: Save note
     *
     * @param id note to delete
     */
    @GetMapping("/delete/{id}")
    public void deletePatient(@PathVariable long id) {
        this.noteService.delete(id);
    }
}
