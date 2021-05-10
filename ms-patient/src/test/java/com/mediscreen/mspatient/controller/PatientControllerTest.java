package com.mediscreen.mspatient.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mediscreen.mspatient.entity.Patient;
import com.mediscreen.mspatient.service.PatientService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Date;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(PatientController.class)
public class PatientControllerTest {
    @MockBean
    PatientService service;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testShow() throws Exception {
        mockMvc.perform(get("/patient/list"))
                .andExpect(status().isOk());
    }

    @Test
    public void testShowAddForm() throws Exception {
        mockMvc.perform(get("/patient/1"))
                .andExpect(status().isOk());
    }

    @Test
    public void testSubmitAddForm() throws Exception {
        Patient patient = new Patient();
        patient.setFamily("Kone");
        patient.setGiven("Ben Fousseni Christ");
        patient.setSex("M");
        patient.setDob(new Date());

        mockMvc.perform(post("/patient/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(patient)))
                .andExpect(status().isOk());
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
