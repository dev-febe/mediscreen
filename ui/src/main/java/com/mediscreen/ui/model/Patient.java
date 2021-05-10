package com.mediscreen.ui.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Patient {
    private Long id;

    /**
     * Patient lastname
     */
    private String family;

    /**
     * Patient firstname
     */
    private String given;

    /**
     * Patient birthdate
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dob;

    /**
     * Patient sex
     */
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
        return "family: "+ family + " given: " + given + " birthdate: " + dob + " sex: "+ sex + " address: " + address + " phone: " + phone;
    }
}
