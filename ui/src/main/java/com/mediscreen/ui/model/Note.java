package com.mediscreen.ui.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Note {
    private Long id;

    private Long patientId;

    private String content;

    @NotNull(message = "Patient is required")
    private Patient patient;

    @Override
    public String toString() {
        return "id: " + id + " content: " + content + " patient: " + patient.toString();
    }
}
