package com.mediscreen.msreport.controller;

import com.mediscreen.msreport.model.Report;
import com.mediscreen.msreport.service.ReportService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReportController {
    ReportService reportService;

    ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    /**
     * Endpoint: /getReportByPatient/{patientId}
     * Desc: Get patient report
     *
     * @param patientId patient id
     * @return Report per patient
     */
    @RequestMapping("/getReportByPatient/{patientId}")
    public Report getReportByPatient(@PathVariable Long patientId) {
        return this.reportService.getReportByPatient(patientId);
    }
}
