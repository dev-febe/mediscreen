package com.mediscreen.ui.controllers;

import com.mediscreen.ui.model.Patient;
import com.mediscreen.ui.service.PatientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PatientController {
    PatientService patientService;

    PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping("/patient/list")
    public String getPatients(Model model) {
        List<Patient> patients = this.patientService.getPatients();

        model.addAttribute("patients", patients);

        return "patient/list";
    }

    @GetMapping("/patient/add")
    public String showAddPatientForm(@ModelAttribute("patient") Patient patient) {
        return "patient/add";
    }

    @PostMapping("/patient/add")
    public String submitAddPatientForm(@ModelAttribute("patient") Patient patient) {
        this.patientService.savePatient(patient);
        return "redirect:/patient/list";
    }

    @GetMapping("/patient/update/{id}")
    public String showUpdatePatientForm(@PathVariable long id, Model model) {
        Patient patient = this.patientService.getPatient(id);

        model.addAttribute("patient", patient);
        return "patient/update";
    }

    @GetMapping("/patient/delete/{id}")
    public String deletePatient(@PathVariable long id) {
        this.patientService.deletePatient(id);
        return "redirect:/patient/list";
    }
}
