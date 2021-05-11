package com.mediscreen.msnote.service;

import com.mediscreen.msnote.entity.Note;
import com.mediscreen.msnote.model.NoteModel;
import com.mediscreen.msnote.model.PatientModel;
import com.mediscreen.msnote.proxy.MsPatientProxy;
import com.mediscreen.msnote.repository.NoteRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class NoteServiceTest {
    @Mock
    MsPatientProxy msPatientProxy;

    @Mock
    NoteRepository noteRepository;

    @Mock
    SequenceGeneratorService sequenceGeneratorService;

    @InjectMocks
    NoteService noteService;

    @Test
    public void test_getAll() {
        List<Note> patients = new ArrayList<>() {{
            add(new Note(1L, 1L, ""));
        }};

        PatientModel expectedPatient = new PatientModel(1L, "Kone", "Ben Fousseni Christ", new Date(), "F", "Abidjan BP 01", "+22577059870", 24);

        Mockito.when(msPatientProxy.getPatients()).thenReturn(new ArrayList<>() {{
            add(expectedPatient);
        }});

        Mockito.when(noteRepository.findAll()).thenReturn(patients);

        Assert.assertEquals(1, noteService.getAll(null).size());
    }

    @Test
    public void test_getById() {
        Note expectedNote = new Note(1L, 1L, "Ben Fousseni Christ");

        PatientModel expectedPatient = new PatientModel(1L, "Kone", "Ben Fousseni Christ", new Date(), "F", "Abidjan BP 01", "+22577059870", 24);

        Mockito.when(msPatientProxy.getPatient(1L)).thenReturn(expectedPatient);

        Mockito.when(noteRepository.findById(any())).thenReturn(Optional.of(expectedNote));

        NoteModel note = noteService.getById(any());

        Assert.assertEquals(note.getContent(), expectedNote.getContent());
    }

    @Test
    public void test_save() {
        Note expectedNote = new Note(1L, 1L, "Ben Fousseni Christ");

        Mockito.when(noteRepository.save(any())).thenReturn(expectedNote);

        Note note = noteService.save(expectedNote);

        Assert.assertEquals(note.getContent(), expectedNote.getContent());
    }


    @Test
    public void test_update() {
        Note expectedNote = new Note(1L, 1L, "Ben Fousseni Christ");
        PatientModel expectedPatient = new PatientModel(1L, "Kone", "Ben Fousseni Christ", new Date(), "F", "Abidjan BP 01", "+22577059870", 24);

        Mockito.when(noteRepository.save(any())).thenReturn(expectedNote);
        Mockito.when(noteRepository.findById(any())).thenReturn(Optional.of(expectedNote));
        Mockito.when(msPatientProxy.getPatient(any())).thenReturn(expectedPatient);



        Note note = noteService.update(1L, expectedNote);

        Assert.assertEquals(note.getContent(), expectedNote.getContent());
    }


    @Test
    public void test_delete() {
        Note expectedNote = new Note(1L, 1L, "Ben Fousseni Christ");

        Mockito.when(noteRepository.findById(any())).thenReturn(Optional.of(expectedNote));

        noteService.delete(1L);

        Mockito.verify(noteRepository, Mockito.times(1)).delete(expectedNote);
    }

}
