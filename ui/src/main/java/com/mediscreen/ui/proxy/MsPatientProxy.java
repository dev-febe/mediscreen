package com.mediscreen.ui.proxy;

import com.mediscreen.ui.model.Patient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "ms-patient", url = "${proxy.ms.patient.url}")
public interface MsPatientProxy {
    @GetMapping("/patient/{id}")
    Patient getPatient(@PathVariable long id);

    @GetMapping("/patient/list")
    List<Patient> getPatients();

    @GetMapping("/patient/delete/{id}")
    void deletePatient(@PathVariable long id);

    @PostMapping("/patient/add")
    void savePatient(@RequestBody Patient patient);

    @PostMapping("/patient/update/{id}")
    Patient updatePatient(@PathVariable Long id, @RequestBody Patient patient);
}

