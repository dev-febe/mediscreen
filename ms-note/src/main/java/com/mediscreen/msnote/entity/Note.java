package com.mediscreen.msnote.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "notes")
public class Note {
    @Transient
    public static final String SEQUENCE_NAME = "note_sequence";
    /**
     * Note identifier
     */
    @Id
    private Long id;

    /**
     * Patient id
     */
    @NotBlank(message = "patient should not be blank")
    private Long patientId;

    /**
     * Note content
     */
    @NotBlank(message = "should not be blank")
    private String content;
}
