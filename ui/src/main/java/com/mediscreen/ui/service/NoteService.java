package com.mediscreen.ui.service;

import com.mediscreen.ui.model.Note;
import com.mediscreen.ui.proxy.MsNoteProxy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {
    MsNoteProxy msNoteProxy;

    NoteService(MsNoteProxy msNoteProxy) {
        this.msNoteProxy = msNoteProxy;
    }

    public List<Note> getNotes() {
        return this.msNoteProxy.getNotes();
    }

    public void saveNote(Note patient) {
        this.msNoteProxy.saveNote(patient);
    }

    public Note getNote(long id) {
        return this.msNoteProxy.getNote(id);
    }

    public void deleteNote(long id) {
        this.msNoteProxy.deleteNote(id);
    }
}
