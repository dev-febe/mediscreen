package com.mediscreen.msnote.proxy;

import com.mediscreen.msnote.model.PatientModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "ms-patient", url = "${proxy.ms.patient.url}")
public interface MsPatientProxy {
    @GetMapping("/patient/{id}")
   PatientModel getPatient(@PathVariable Long id);

    @GetMapping("/patient/list")
    List<PatientModel> getPatients();
}
