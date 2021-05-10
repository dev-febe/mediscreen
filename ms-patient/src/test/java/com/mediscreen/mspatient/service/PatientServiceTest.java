package com.mediscreen.mspatient.service;

import com.mediscreen.mspatient.entity.Patient;
import com.mediscreen.mspatient.repository.PatientRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class PatientServiceTest {
    @Mock
    PatientRepository patientRepository;

    @InjectMocks
    PatientService patientService;

    @Test
    public void test_getAll() {
        List<Patient> patients = new ArrayList<>() {{
            add(new Patient(1L, "Kone", "Ben Fousseni Christ", new Date(), "F", "Abidjan BP 01", "+22577059870", 24));
        }};

        Mockito.when(patientRepository.findAll()).thenReturn(patients);

        Assert.assertEquals(1, patientService.getAll().size());
    }

    @Test
    public void test_getById() {
        Patient expectedPatient = new Patient(1L, "Kone", "Ben Fousseni Christ", new Date(), "F", "Abidjan BP 01", "+22577059870", 24);

        Mockito.when(patientRepository.findById(any())).thenReturn(Optional.of(expectedPatient));

        Patient patient = patientService.getById(any());

        Assert.assertEquals(patient.getFamily(), expectedPatient.getFamily());
    }

    @Test
    public void test_save() {
        Patient expectedPatient = new Patient(1L, "Kone", "Ben Fousseni Christ", new Date(), "F", "Abidjan BP 01", "+22577059870", 24);

        Mockito.when(patientRepository.save(any())).thenReturn(expectedPatient);

        Patient patient = patientService.save(expectedPatient);

        Assert.assertEquals(patient.getFamily(), expectedPatient.getFamily());
    }

}
