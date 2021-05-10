package com.mediscreen.ui.controllers;

import com.mediscreen.ui.model.Note;
import com.mediscreen.ui.model.Patient;
import com.mediscreen.ui.service.NoteService;
import com.mediscreen.ui.service.PatientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


@Controller
public class NoteController {
    NoteService noteService;
    PatientService patientService;

    NoteController(NoteService noteService, PatientService patientService) {
        this.noteService = noteService;
        this.patientService = patientService;
    }

    @GetMapping("/note/list")
    public String getNotes(Model model) {
        List<Note> notes = this.noteService.getNotes();

        model.addAttribute("notes", notes);

        return "note/list";
    }

    @GetMapping("/note/add")
    public String showAddNoteForm(@ModelAttribute("note") Note note, Model model) {
        List<Patient> patients = this.patientService.getPatients();

        model.addAttribute("patients", patients);

        return "note/add";
    }

    @PostMapping("/note/add")
    public String submitAddNoteForm(@ModelAttribute("note") Note note, Model model) {
        this.noteService.saveNote(note);

        List<Note> notes = this.noteService.getNotes();
        model.addAttribute("notes", notes);

        return "redirect:/note/list";
    }

    @GetMapping("/note/update/{id}")
    public String showUpdateNoteForm(@PathVariable long id, Model model) {
        Note note = this.noteService.getNote(id);
        List<Note> notes = this.noteService.getNotes();

        model.addAttribute("note", note);
        model.addAttribute("notes", notes);

        return "redirect:/note/list";
    }

    @GetMapping("/note/delete/{id}")
    public String deleteNote(@PathVariable long id, Model model) {
        this.noteService.deleteNote(id);
        List<Note> notes = this.noteService.getNotes();

        model.addAttribute("notes", notes);

        return "redirect:/note/list";
    }
}
