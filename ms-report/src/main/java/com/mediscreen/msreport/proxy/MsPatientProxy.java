package com.mediscreen.msreport.proxy;

import com.mediscreen.msreport.model.Patient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ms-patient", url = "${proxy.ms.patient.url}")
public interface MsPatientProxy {
    @GetMapping("/patient/{id}")
    Patient getPatient(@PathVariable Long id);
}
