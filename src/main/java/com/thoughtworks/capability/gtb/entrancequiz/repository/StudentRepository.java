package com.thoughtworks.capability.gtb.entrancequiz.repository;

import com.thoughtworks.capability.gtb.entrancequiz.dto.StudentDto;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class StudentRepository {
    List<StudentDto> students = new ArrayList<>(
            Arrays.asList(new StudentDto(1, "成吉思汗"),
                    new StudentDto(2, "鲁班七号"),
                    new StudentDto(3, "太乙真人"),
                    new StudentDto(4, "钟无艳"),
                    new StudentDto(5, "花木兰"),
                    new StudentDto(6, "雅典娜"),
                    new StudentDto(7, "芈月"),
                    new StudentDto(8, "白起"),
                    new StudentDto(9, "刘婵"),
                    new StudentDto(10, "庄周"),
                    new StudentDto(11, "马超"),
                    new StudentDto(12, "刘备"),
                    new StudentDto(13, "哪吒"),
                    new StudentDto(14, "大乔"),
                    new StudentDto(15, "蔡文姬")));

    public List<StudentDto> getAllStudents() {
        return students;
    }

    public void addStudent(String name) {
        students.add(new StudentDto(students.size() + 1, name));
    }
}
