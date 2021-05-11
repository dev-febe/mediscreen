package com.mediscreen.ui.service;

import com.mediscreen.ui.model.Patient;
import com.mediscreen.ui.proxy.MsPatientProxy;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service which serves PatientController
 */
@Service
public class PatientService {
    MsPatientProxy msPatientProxy;

    PatientService(
            MsPatientProxy msPatientProxy
    ) {
        this.msPatientProxy = msPatientProxy;
    }

    /**
     * Get all patients
     *
     * @return list of patients
     */
    public List<Patient> getPatients() {
        return this.msPatientProxy.getPatients();
    }

    /**
     * Get a patient
     *
     * @param id patient id
     * @return specific patient
     */
    public Patient getPatient(long id) {
        return this.msPatientProxy.getPatient(id);
    }

    /**
     * Delete a specific patient by given id
     *
     * @param id patient id
     */
    public void deletePatient(long id) {
        this.msPatientProxy.deletePatient(id);
    }

    /**
     * Save a specific patient from request body
     *
     * @param patient patient request body
     */
    public void savePatient(Patient patient) {
        this.msPatientProxy.savePatient(patient);
    }

    public void updatePatient(long id, Patient patient) {
        this.msPatientProxy.updatePatient(id, patient);
    }
}
