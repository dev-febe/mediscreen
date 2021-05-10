package com.mediscreen.msnote.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NoteModel {
    private long id;

    /**
     * Patient
     */
    private PatientModel patient;

    /**
     * Note content
     */
    private String content;
}
