package com.thoughtworks.capability.gtb.entrancequiz.service;

import com.thoughtworks.capability.gtb.entrancequiz.dto.StudentDto;
import com.thoughtworks.capability.gtb.entrancequiz.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public List<StudentDto> getAllStudents() {
        return studentRepository.getAllStudents();
    }

    public void addStudent(String name) {
        studentRepository.addStudent(name);
    }

    public Map<String, List<StudentDto>> getAllRandomGroups() {
        studentRepository.clear();
        List<StudentDto> newStudents = new ArrayList<>(studentRepository.getAllStudents());
        int studentCount = newStudents.size();
        int restStudentNumber = studentCount % 6;
        for (int groupId = 1; groupId <= 6; groupId++) {
            int groupAvgNumber = studentCount / 6;
            if (restStudentNumber > 0) {
                groupAvgNumber++;
                restStudentNumber--;
            }
            randomStudent(newStudents, groupAvgNumber, groupId + " 组");
        }
        return studentRepository.getGroups();
    }

    private void randomStudent(List<StudentDto> newStudents, int groupAvgNumber, String groupName) {
        Random random = new Random();
        for (int i = 0; i < groupAvgNumber; i++) {
            int randomIndex = random.nextInt(newStudents.size());
            StudentDto randomStudent = newStudents.get(randomIndex);
            studentRepository.joinGroup(groupName, randomStudent);
            newStudents.remove(randomIndex);
        }
    }
}
