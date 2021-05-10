package com.mediscreen.mspatient.repository;

import com.mediscreen.mspatient.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    List<Patient> findAll();

    Optional<Patient> findById(long id);

    Patient save(Patient patient);

    void delete(Patient patient);
}
