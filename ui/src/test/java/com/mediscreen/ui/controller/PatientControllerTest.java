package com.mediscreen.ui.controller;

import com.mediscreen.ui.controllers.PatientController;
import com.mediscreen.ui.service.PatientService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
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
                .andExpect(status().is4xxClientError());
    }
}
