package com.mediscreen.mspatient.service;

import com.mediscreen.mspatient.entity.Patient;
import com.mediscreen.mspatient.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Service which serves PatientController
 */
@Service
public class PatientService {
    PatientRepository patientRepository;

    PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    /**
     * Get the list of all patient
     *
     * @return Patient List
     */
    public List<Patient> getAll() {
        return this.patientRepository
                .findAll()
                .stream()
                .peek(this::updatePatientAge).collect(Collectors.toList());
    }

    /**
     * Update patient age
     *
     * @param patient given patient
     */
    public void updatePatientAge(Patient patient) {
        LocalDate personBirthDate = patient
                .getDob()
                .toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
        LocalDate now = LocalDate.now();
        Period period = Period.between(now, personBirthDate);
        patient.setAge(Math.abs(period.getYears()));
    }

    /**
     * Get the specific patient
     *
     * @param id patient Id
     * @return specific patient
     */
    public Patient getById(Long id) {
        Optional<Patient> _patient = this.patientRepository.findById(id);
        if (_patient.isEmpty()) {
            throw new Error("Patient not found");
        }
        Patient patient = _patient.get();

        updatePatientAge(patient);

        return patient;
    }
}
