package com.mediscreen.mspatient.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Patient {
    @Id
    @GeneratedValue
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
