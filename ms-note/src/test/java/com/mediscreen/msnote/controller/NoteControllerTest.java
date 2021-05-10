package com.mediscreen.msnote.controller;

import com.mediscreen.msnote.service.NoteService;
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
@WebMvcTest(NoteController.class)
public class NoteControllerTest {
    @MockBean
    NoteService service;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testShow() throws Exception {
        mockMvc.perform(get("/note/list"))
                .andExpect(status().isOk());
    }

    @Test
    public void testShowAddForm() throws Exception {
        mockMvc.perform(get("/note/1"))
                .andExpect(status().isOk());
    }
}
