package com.mediscreen.mspatient.repository;

import com.mediscreen.mspatient.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    /**
     * Find all patients
     *
     * @return list of patients
     */
    List<Patient> findAll();

    /**
     * Get a specific patient by given id
     *
     * @param id patient id
     * @return patient found
     */
    Optional<Patient> findById(long id);

    /**
     * Save or update a patient
     *
     * @param patient patient to save
     * @return patient saved
     */
    Patient save(Patient patient);

    /**
     * Delete a patient
     *
     * @param patient to delete
     */
    void delete(Patient patient);
}
