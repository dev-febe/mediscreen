package com.mediscreen.mspatient.controller;

import com.mediscreen.mspatient.entity.Patient;
import com.mediscreen.mspatient.service.PatientService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Controller for handle all patient CRUD
 */
@RestController
@RequestMapping("/patient")
public class PatientController {
    PatientService patientService;

    PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    /**
     * Endpoint: /patient
     * Desc: Welcome to patient service
     *
     * @return String
     */
    @GetMapping("/")
    public String index() {
        return "Greeting to Patient Microservice";
    }

    /**
     * Endpoint: /patient/list
     * Desc: Get the list of all patient
     *
     * @return List of patient
     */
    @GetMapping("/list")
    public List<Patient> getPatients() {
        return this.patientService.getAll();
    }

    /**
     * Endpoint: /patient/id
     * Desc: Get specific patient
     *
     * @param id patient id
     * @return a specific patient
     */
    @GetMapping("/{id}")
    public Patient getPatient(@PathVariable Long id) {
        return this.patientService.getById(id);
    }

    /**
     * Endpoint: /patient/add
     * Desc: Save a patient
     *
     * @param patient patient body to save
     * @return patient saved
     */
    @PostMapping("/add")
    public Patient postPatient(@RequestBody @Valid Patient patient) {
        return this.patientService.save(patient);
    }
}
