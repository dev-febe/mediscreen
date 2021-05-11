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
     * Endpoint: /assess/{id}
     * Desc: Get patient report
     *
     * @param id patient id
     * @return Report per patient
     */
    @RequestMapping("/assess/{id}")
    public Report getReportByPatient(@PathVariable Long id) {
        return this.reportService.getReportByPatient(id);
    }
}
