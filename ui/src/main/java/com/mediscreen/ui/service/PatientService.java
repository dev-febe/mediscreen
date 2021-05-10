package com.mediscreen.ui.service;

import com.mediscreen.ui.model.Patient;
import com.mediscreen.ui.proxy.MsNoteProxy;
import com.mediscreen.ui.proxy.MsPatientProxy;
import com.mediscreen.ui.proxy.MsReportProxy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {
    MsPatientProxy msPatientProxy;
    MsNoteProxy msNoteProxy;
    MsReportProxy msReportProxy;

    PatientService(
            MsPatientProxy msPatientProxy,
            MsNoteProxy msNoteProxy,
            MsReportProxy msReportProxy
    ) {
        this.msPatientProxy = msPatientProxy;
        this.msNoteProxy = msNoteProxy;
        this.msReportProxy = msReportProxy;
    }

    public List<Patient> getPatients() {
        return this.msPatientProxy.getPatients();
    }

    public void deletePatient(long id) {
        this.msPatientProxy.deletePatient(id);
    }

    public void savePatient(Patient patient) {
        this.msPatientProxy.savePatient(patient);
    }

    public Patient getPatient(long id) {
        return this.msPatientProxy.getPatient(id);
    }
}
