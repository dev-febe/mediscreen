package com.mediscreen.ui.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Patient {
    private Long id;

    /**
     * Patient lastname
     */
    @NotBlank(message = "Patient family name is required")
    private String family;

    /**
     * Patient firstname
     */
    @NotBlank(message = "Patient given name is required")
    private String given;

    /**
     * Patient birthdate
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "Patient birthdate should not be null")
    private Date dob;

    /**
     * Patient sex
     */
    @NotBlank(message = "Patient sex is required")
    private String sex;

    /**
     * Patient address
     */
    private String address;

    /**
     * Patient phone
     */
    private String phone;

    /**
     * Patient age
     */
    private int age;

    @Override
    public String toString() {
        return "id: " + id + "family: " + family + " given: " + given + " birthdate: " + dob + " sex: " + sex + " address: " + address + " phone: " + phone;
    }
}
