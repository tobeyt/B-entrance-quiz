package com.thoughtworks.capability.gtb.entrancequiz.controller;

import com.thoughtworks.capability.gtb.entrancequiz.dto.StudentDto;
import com.thoughtworks.capability.gtb.entrancequiz.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin
public class StudentController {
    @Autowired
    StudentService studentService;

    @GetMapping("/students")
    public ResponseEntity<List<StudentDto>> getAllStudents(){
        List<StudentDto> studentDtoList = studentService.getAllStudents();
        return ResponseEntity.ok(studentDtoList);
    }

    @PostMapping("/student/{name}")
    public ResponseEntity addStudent(@PathVariable String name){
        studentService.addStudent(name);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
