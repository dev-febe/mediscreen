package com.mediscreen.ui.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Note {
    private Long id;

    private Long patientId;

    private String content;

    private Patient patient;
}
