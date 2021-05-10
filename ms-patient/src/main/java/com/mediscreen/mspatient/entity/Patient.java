package com.mediscreen.mspatient.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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
    @NotBlank(message = "Family name should not be blank")
    private String family;

    /**
     * Patient firstname
     */
    @NotBlank(message = "Given name should not be blank")
    private String given;

    /**
     * Patient birthdate
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "Day of birthday should not be blank")
    private Date dob;

    /**
     * Patient sex
     */
    @NotBlank(message = "Sex should not be blank")
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
