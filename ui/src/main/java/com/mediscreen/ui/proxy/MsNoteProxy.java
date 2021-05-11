package com.mediscreen.ui.proxy;

import com.mediscreen.ui.model.Note;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "ms-note", url = "${proxy.ms.note.url}")
public interface MsNoteProxy {
    @GetMapping("/note/{id}")
    Note getNote(@PathVariable Long id);

    @GetMapping("/note/list")
    List<Note> getNotes(@RequestParam long patientId);

    @GetMapping("/note/list")
    List<Note> getNotes();

    @PostMapping("/note/add")
    void saveNote(Note patient);

    @PostMapping("/note/update/{id}")
    Note updateNote(@PathVariable long id, @RequestBody Note note);

    @GetMapping("/note/delete/{id}")
    void deleteNote(@PathVariable long id);

}
