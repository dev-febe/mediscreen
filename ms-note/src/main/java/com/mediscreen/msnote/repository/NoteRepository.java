package com.mediscreen.msnote.repository;

import com.mediscreen.msnote.entity.Note;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface NoteRepository extends MongoRepository<Note, Long> {
    /**
     * Find all notes
     *
     * @return List of notes
     */
    List<Note> findAll();

    /**
     * Find patient note by givent patient id
     *
     * @param id patient id
     * @return List of notes
     */
    List<Note> findByPatientId(Long id);

    /**
     * Find a specific patient by given id
     *
     * @param id patient id
     * @return Notes found
     */
    Optional<Note> findById(Long id);

    /**
     * Save a note
     *
     * @param note note to save
     * @return note saved
     */
    Note save(Note note);

    /**
     * Delete a note
     *
     * @param note note to delete
     */
    void delete(Note note);
}
