package com.mediscreen.mspatient.controller;

import com.mediscreen.mspatient.entity.Patient;
import com.mediscreen.mspatient.service.PatientService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController {
    PatientService patientService;

    PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping("/")
    public String index() {
        return "Greeting to Patient Microservice";
    }

    @GetMapping("/list")
    public List<Patient> getPatients() {
        return this.patientService.getAll();
    }

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

    /**
     * Endpoint: /patient/update
     * Desc: Update a patient
     *
     * @param id      patient id
     * @param patient patient to update
     * @return patient updated
     */
    @PostMapping("/update/{id}")
    public Patient putPatient(@PathVariable Long id, @RequestBody @Valid Patient patient) {
        return this.patientService.update(id, patient);
    }

    /**
     * Endpoint: /patient/update
     * Desc: Update a patient
     *
     * @param id patient id
     */
    @GetMapping("/delete/{id}")
    public void deletePatient(@PathVariable long id) {
        this.patientService.delete(id);
    }
}
