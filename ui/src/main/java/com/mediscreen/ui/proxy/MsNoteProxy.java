package com.mediscreen.ui.proxy;

import com.mediscreen.ui.model.Note;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "ms-note", url = "${proxy.ms.note.url}")
public interface MsNoteProxy {
    @GetMapping("/patHistory/{id}")
    Note getNote(@PathVariable Long id);

    @GetMapping("/patHistory/list")
    List<Note> getNotes(@RequestParam long patientId);

    @GetMapping("/patHistory/list")
    List<Note> getNotes();

    @PostMapping("/patHistory/add")
    void saveNote(Note patient);

    @PostMapping("/patHistory/update/{id}")
    Note updateNote(@PathVariable long id, @RequestBody Note note);

    @GetMapping("/patHistory/delete/{id}")
    void deleteNote(@PathVariable long id);
}
