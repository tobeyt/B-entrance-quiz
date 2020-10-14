package com.thoughtworks.capability.gtb.entrancequiz.controller;

import com.thoughtworks.capability.gtb.entrancequiz.dto.StudentDto;
import com.thoughtworks.capability.gtb.entrancequiz.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

// GTB: 推荐使用@RestController
@Controller
@CrossOrigin
public class StudentController {
    // GTB: 推荐使用构造函数d注入
    // GTB: 封装性，字段应该使用private修饰
    @Autowired
    StudentService studentService;

    @GetMapping("/students")
    public ResponseEntity<List<StudentDto>> getAllStudents(){
        List<StudentDto> studentDtoList = studentService.getAllStudents();
        return ResponseEntity.ok(studentDtoList);
    }

    // GTB: Restful实践, url不合理
    // GTB: Restful实践, requestBody和responseBody不合理
    @PostMapping("/student/{name}")
    public ResponseEntity addStudent(@PathVariable String name){
        studentService.addStudent(name);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/random")
    // GTB: Restful实践, http动词不合理
    public ResponseEntity<Map<String, List<StudentDto>>> getRandomGroups(){
        studentService.getAllRandomGroups();
        return ResponseEntity.ok(studentService.getAllRandomGroups());
    }

    @GetMapping("/groups")
    public ResponseEntity<Map<String, List<StudentDto>>> getGroups(){
        return ResponseEntity.ok(studentService.getGroups());
    }
}
