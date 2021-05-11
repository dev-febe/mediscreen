package com.mediscreen.ui.proxy;

import com.mediscreen.ui.model.Note;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "ms-note", url = "${proxy.ms.note.url}")
public interface MsNoteProxy {
    @GetMapping("/note/{id}")
    Note getNote(@PathVariable long id);

    @GetMapping("/note/list")
    List<Note> getNotes(@RequestParam long patientId);

    @GetMapping("/note/list")
    List<Note> getNotes();

    @PostMapping("/note/add")
    void saveNote(Note patient);

    @GetMapping("/note/delete/{id}")
    void deleteNote(@PathVariable long id);
}
