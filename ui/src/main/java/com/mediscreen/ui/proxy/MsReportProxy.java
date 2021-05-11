package com.mediscreen.ui.proxy;

import com.mediscreen.ui.model.Report;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "ms-report", url = "${proxy.ms.report.url}")
public interface MsReportProxy {
    @RequestMapping("getReportByPatient/{patientId}")
    Report getReportByPatient(@PathVariable Long patientId);
}
