package com.mediscreen.msreport.service;

import com.mediscreen.msreport.model.Note;
import com.mediscreen.msreport.model.Patient;
import com.mediscreen.msreport.model.Report;
import com.mediscreen.msreport.proxy.MsNoteProxy;
import com.mediscreen.msreport.proxy.MsPatientProxy;
import org.springframework.stereotype.Service;

import java.util.*;
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

        Set<String> triggersFound = new LinkedHashSet<>();
        notes.forEach(note -> {
            triggers.forEach(trigger -> {
                if (note.getContent().contains(trigger)) {
                    triggersFound.add(trigger);
                }
            });
        });

        String risk = getRisk(patient.getAge(), patient.getSex(), triggersFound.size());
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

        boolean isBorderline = (age > 30 && trigger >= 2);
        risk = isBorderline ? "Borderline" : risk;

        boolean isInDanger = (age < 30 && (patSex.equals("M") && trigger >= 3) || patSex.equals("F") && trigger >= 4)
                || (age > 30 && trigger >= 6);
        risk = isInDanger ? "In Danger" : risk;

        boolean isEarlyOnset = (age < 30 && (patSex.equals("M") && trigger >= 5 || patSex.equals("F") && trigger >= 7))
                || (age > 30 && trigger >= 8);
        risk = isEarlyOnset ? "EarlyOnset" : risk;

        return risk;
    }
}
