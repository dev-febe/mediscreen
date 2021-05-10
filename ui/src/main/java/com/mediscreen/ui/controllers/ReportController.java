package com.mediscreen.ui.controllers;

import com.mediscreen.ui.model.Patient;
import com.mediscreen.ui.model.Report;
import com.mediscreen.ui.service.PatientService;
import com.mediscreen.ui.service.ReportService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ReportController {
    ReportService reportService;
    PatientService patientService;

    ReportController(ReportService reportService, PatientService patientService) {
        this.reportService = reportService;
        this.patientService = patientService;
    }

    @GetMapping("/report/generate")
    public String showGenerateReport(@ModelAttribute("report") Report report, Model model) {
        List<Patient> patients = this.patientService.getPatients();

        model.addAttribute("patients", patients);

        return "report/generate";
    }

    @PostMapping("/report/generate")
    public String submitGenerateReport(@ModelAttribute("report") Report report, Model model) {
        List<Patient> patients = this.patientService.getPatients();

        Report reportResult = this.reportService.generateReport(report);

        model.addAttribute("patients", patients);
        model.addAttribute("reportDescription", reportResult.getDescription());

        return "report/generate";
    }
}
