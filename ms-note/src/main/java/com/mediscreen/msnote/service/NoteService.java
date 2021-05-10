package com.mediscreen.msnote.service;

import com.mediscreen.msnote.entity.Note;
import com.mediscreen.msnote.model.NoteModel;
import com.mediscreen.msnote.model.PatientModel;
import com.mediscreen.msnote.proxy.MsPatientProxy;
import com.mediscreen.msnote.repository.NoteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Service which serves NoteController
 */
@Service
public class NoteService {
    MsPatientProxy msPatientProxy;
    NoteRepository noteRepository;
    SequenceGeneratorService sequenceGeneratorService;

    NoteService(
            MsPatientProxy msPatientProxy,
            NoteRepository noteRepository,
            SequenceGeneratorService sequenceGeneratorService
    ) {
        this.msPatientProxy = msPatientProxy;
        this.noteRepository = noteRepository;
        this.sequenceGeneratorService = sequenceGeneratorService;
    }

    /**
     * Get all notes
     *
     * @param patientId patient id
     * @return List of patient
     */
    public List<NoteModel> getAll(Long patientId) {
        List<Note> notes;
        if (patientId != null) {
            notes = this.noteRepository.findByPatientId(patientId);
        } else {
            notes = this.noteRepository.findAll();
        }

        List<PatientModel> patients = this.msPatientProxy.getPatients();

        return notes.stream()
                .map(note -> updateNotePatient(note, patients))
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    /**
     * Update patient note
     *
     * @param note     patient note
     * @param patients all patients got for MS-PATIENT
     * @return note updated
     */
    private NoteModel updateNotePatient(Note note, List<PatientModel> patients) {
        Optional<PatientModel> patient = patients.stream()
                .filter(_patient -> _patient.getId().equals(note.getPatientId()))
                .findFirst();
        if (patient.isEmpty()) {
            return null;
        } else {
            return new NoteModel(note.getId(), patient.get(), note.getContent());
        }
    }

    /**
     * Update patient note
     *
     * @param note    patient note
     * @param patient patient
     * @return note updated
     */
    private NoteModel updateNotePatient(Note note, PatientModel patient) {
        return new NoteModel(note.getId(), patient, note.getContent());
    }

    /**
     * Get a specific patient by given id
     *
     * @param id note id
     * @return note found
     */
    public NoteModel getById(Long id) {
        Optional<Note> note = this.noteRepository.findById(id);
        if (note.isEmpty()) {
            throw new Error("Note not found");
        }

        PatientModel patient = this.msPatientProxy.getPatient(note.get().getPatientId());

        if (patient == null) {
            throw new Error("Note not found");
        }

        return updateNotePatient(note.get(), patient);
    }

    /**
     * Save a note
     *
     * @param note note to save
     * @return note saved
     */
    public Note save(Note note) {
        note.setId(sequenceGeneratorService.generateSequence(Note.SEQUENCE_NAME));
        return this.noteRepository.save(note);
    }
}
