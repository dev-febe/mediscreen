package com.mediscreen.msreport.service;

import com.mediscreen.msreport.model.Patient;
import com.mediscreen.msreport.proxy.MsNoteProxy;
import com.mediscreen.msreport.proxy.MsPatientProxy;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;

@ExtendWith(MockitoExtension.class)
public class ReportServiceTest {
    @Mock
    MsPatientProxy msPatientProxy;

    @Mock
    MsNoteProxy msNoteProxy;

    @InjectMocks
    ReportService reportService;

    @Test
    public void test_getAll() {
        Patient expectedPatient = new Patient(1L, "Kone", "Ben Fousseni Christ", new Date(), "F", "Abidjan BP 01", "+22577059870", 24);

        Mockito.when(msPatientProxy.getPatient(1L)).thenReturn(expectedPatient);

        reportService.getReportByPatient(1L);
    }
}
