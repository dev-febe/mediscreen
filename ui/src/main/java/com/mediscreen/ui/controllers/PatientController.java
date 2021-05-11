package com.mediscreen.ui.controllers;

import com.mediscreen.ui.model.Patient;
import com.mediscreen.ui.service.PatientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Controller for handling patient UI CRUD
 */
@Controller
public class PatientController {
    PatientService patientService;

    PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    /**
     * Endpoint: /patient/list
     * Desc: Get the list of all patient
     *
     * @return List of patient
     */
    @GetMapping("/patient/list")
    public String getPatients(Model model) {
        List<Patient> patients = this.patientService.getPatients();

        model.addAttribute("patients", patients);

        return "patient/list";
    }

    /**
     * Endpoint: /patient/list
     * Desc: show form for adding new patient
     *
     * @return List of patient
     */
    @GetMapping("/patient/add")
    public String showAddPatientForm(@ModelAttribute("patient") Patient patient) {
        return "patient/add";
    }

    /**
     * Endpoint: /patient/list
     * Desc: Create a new patient
     *
     * @return List of patient
     */
    @PostMapping("/patient/add")
    public String submitAddPatientForm(@ModelAttribute("patient") @Valid Patient patient, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            this.patientService.savePatient(patient);
            return "redirect:/patient/list";
        }

        return "patient/add";
    }

    /**
     * Endpoint: /patient/list
     * Desc: Update a patient by given id
     *
     * @return List of patient
     */
    @GetMapping("/patient/update/{id}")
    public String showUpdatePatientForm(@PathVariable long id, Model model) {
        Patient patient = this.patientService.getPatient(id);

        model.addAttribute("patient", patient);
        return "patient/update";
    }

    /**
     * Endpoint: /patient/list
     * Desc: Create a new patient
     *
     * @return List of patient
     */
    @PostMapping("/patient/update/{id}")
    public String submitUpdatePatientForm(@PathVariable long id, @ModelAttribute("patient") @Valid Patient patient, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            this.patientService.updatePatient(id, patient);
            return "redirect:/patient/list";
        }

        return "patient/update";
    }

    /**
     * Endpoint: /patient/list
     * Desc: Delete a patient
     *
     * @return List of patient
     */
    @GetMapping("/patient/delete/{id}")
    public String deletePatient(@PathVariable long id) {
        this.patientService.deletePatient(id);
        return "redirect:/patient/list";
    }
}
