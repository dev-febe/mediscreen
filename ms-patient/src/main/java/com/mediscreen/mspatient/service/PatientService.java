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

    /**
     * Save a patients
     *
     * @param patient patient to save
     * @return patient saved
     */
    public Patient save(Patient patient) {
        return this.patientRepository.save(patient);
    }


    /**
     * Save a patients
     *
     * @param patientToUpdate patient to update
     * @return patient saved
     */
    public Patient update(long id, Patient patientToUpdate) {
        Patient patient = this.getById(id);

        patient.setFamily(patientToUpdate.getFamily());
        patient.setGiven(patientToUpdate.getGiven());
        patient.setDob(patientToUpdate.getDob());
        patient.setSex(patientToUpdate.getSex());
        patient.setAddress(patientToUpdate.getAddress());
        patient.setPhone(patientToUpdate.getPhone());

        return this.patientRepository.save(patient);
    }

    /**
     * Delete a patient
     *
     * @param id patient id
     */
    public void delete(long id) {
        Patient patient = this.getById(id);
        this.patientRepository.delete(patient);
    }
}
