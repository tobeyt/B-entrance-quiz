package com.thoughtworks.capability.gtb.entrancequiz.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
class StudentRepositoryTest {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    StudentRepository studentRepository;

    @Test
    void shouldGetAllStudents() throws Exception {
        mockMvc.perform(get("/students"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id", is(1)));
    }

    @Test
    void shouldSuccessAddOneStudent() throws Exception {
        mockMvc.perform(post("/student/qindi"))
                .andExpect(status().isCreated());

        assertEquals(16, studentRepository.getAllStudents().size());
        assertEquals("qindi", studentRepository.getAllStudents().get(15).getName());
    }

    @Test
    void shouldGetShuffedGroup() throws Exception {
        mockMvc.perform(get("/random"))
                .andExpect(status().isOk());

        assertEquals(studentRepository.getGroups().get("1 组").size(), 3);
        assertEquals(studentRepository.getGroups().get("6 组").size(), 2);
    }

    @Test
    void shouldGetGroups() throws Exception{
        mockMvc.perform(get("/groups"))
                .andExpect(status().isOk());

        assertEquals(studentRepository.getGroups().get("1 组").size(), 3);
        assertEquals(studentRepository.getGroups().get("6 组").size(), 2);
    }
}