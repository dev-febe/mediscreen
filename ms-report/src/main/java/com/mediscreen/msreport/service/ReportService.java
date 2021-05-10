package com.mediscreen.msreport.service;

import com.mediscreen.msreport.model.Note;
import com.mediscreen.msreport.model.Patient;
import com.mediscreen.msreport.model.Report;
import com.mediscreen.msreport.proxy.MsNoteProxy;
import com.mediscreen.msreport.proxy.MsPatientProxy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class ReportService {
    MsPatientProxy patientProxy;
    MsNoteProxy noteProxy;

    ReportService(MsPatientProxy patientProxy, MsNoteProxy noteProxy) {
        this.patientProxy = patientProxy;
        this.noteProxy = noteProxy;
    }

    /**
     * Get report per patient
     *
     * @param patientId patient id
     * @return report of patient
     */
    public Report getReportByPatient(Long patientId) {
        Patient patient = this.patientProxy.getPatient(patientId);
        List<Note> notes = this.noteProxy.getNotes(patientId);
        AtomicInteger triggerNb = new AtomicInteger();

        // TODO create a table for manage this part
        List<String> triggers = new ArrayList<>() {{
            add("Hémoglobine A1C");
            add("Microalbumine");
            add("Taille");
            add("Poids");
            add("Fumeur");
            add("Anormal");
            add("Cholestérol");
            add("Vertige");
            add("Rechute");
            add("Réaction");
            add("Anticorps");
        }};

        notes.forEach(note -> {
            triggers.forEach(trigger -> {
                if (note.getContent().contains(trigger)) {
                    triggerNb.addAndGet(1);
                }
            });
        });

        String risk = getRisk(patient.getAge(), patient.getSex(), triggerNb.get());
        String reportDescription = "Patient: " + patient.getFamily() + " " + patient.getGiven() + " (age " + patient.getAge() + ") diabetes assessment is: " + risk + "";

        return new Report(risk, reportDescription);
    }

    /**
     * Get patient risk
     *
     * @param age     Age of patient
     * @param patSex  Sex of the patient
     * @param trigger Trigger provided by patient note
     * @return risk
     */
    private String getRisk(int age, String patSex, int trigger) {
        String risk = "None";
        String sex = "M";
        if (age > 30) {
            if (trigger == 2)
                risk = "Borderline";
            if (trigger == 6)
                risk = "In Danger";
            if (trigger >= 6)
                risk = "Early onset";
        } else {
            if (sex.equals(patSex)) {
                if (trigger == 3)
                    risk = "In Danger";
                if (trigger == 5)
                    risk = "Early onset";
            } else {
                if (trigger == 4)
                    risk = "In Danger";
                if (trigger == 7)
                    risk = "Early onset";
            }
        }
        return risk;
    }
}
