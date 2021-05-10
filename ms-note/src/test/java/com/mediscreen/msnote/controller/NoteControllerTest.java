package com.mediscreen.msnote.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mediscreen.msnote.entity.Note;
import com.mediscreen.msnote.service.NoteService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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

    @Test
    public void testSubmitAddForm() throws Exception {
        Note note = new Note();
        note.setPatientId(1L);
        note.setContent("Note Content");

        mockMvc.perform(post("/note/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(note)))
                .andExpect(status().isOk());
    }

    @Test
    public void testSubmitUpdateForm() throws Exception {
        Note note = new Note();
        note.setPatientId(1L);
        note.setContent("Note Content");

        mockMvc.perform(post("/note/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(note)))
                .andExpect(status().isOk());
    }

    @Test
    public void testDelete() throws Exception {
        mockMvc.perform(get("/note/delete/1"))
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
