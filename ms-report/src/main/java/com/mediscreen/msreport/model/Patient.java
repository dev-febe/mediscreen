package com.mediscreen.msreport.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    @JsonFormat(pattern = "yyyy-MM-dd")
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
}
