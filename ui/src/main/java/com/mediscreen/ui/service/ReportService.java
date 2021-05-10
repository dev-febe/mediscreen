package com.mediscreen.ui.service;

import com.mediscreen.ui.model.Report;
import com.mediscreen.ui.proxy.MsReportProxy;
import org.springframework.stereotype.Service;

@Service
public class ReportService {
    MsReportProxy msReportProxy;

    ReportService(MsReportProxy msReportProxy) {
        this.msReportProxy = msReportProxy;
    }

    public Report generateReport(Report report) {
        return this.msReportProxy.getReportByPatient(report.getPatientId());
    }
}
