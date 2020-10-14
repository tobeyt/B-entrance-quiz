package com.thoughtworks.capability.gtb.entrancequiz.repository;

import com.thoughtworks.capability.gtb.entrancequiz.dto.StudentDto;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class StudentRepository {
    private List<StudentDto> students = new ArrayList<>(
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

    // GTB: 不推荐使用双花括号初始化Map
    // GTB: 小组应该在第一次分组时才创建
    private Map<String, List<StudentDto>> groups = new HashMap<String, List<StudentDto>>(){
        {
            // GTB: Magic Number
            put("1 组", new ArrayList<>());
            put("2 组", new ArrayList<>());
            put("3 组", new ArrayList<>());
            put("4 组", new ArrayList<>());
            put("5 组", new ArrayList<>());
            put("6 组", new ArrayList<>());
        }
    };

    public List<StudentDto> getStudents() {
        return students;
    }

    public void setStudents(List<StudentDto> students) {
        this.students = students;
    }

    public void setGroups(Map<String, List<StudentDto>> groups) {
        this.groups = groups;
    }

    public List<StudentDto> getAllStudents() {
        return students;
    }

    public void addStudent(String name) {
        // GTB: “studentList.size() + 1”不可读，建议引入中间变量
        students.add(new StudentDto(students.size() + 1, name));
    }

    public void clear() {
        groups.values().forEach(List::clear);
    }

    public Map<String, List<StudentDto>> getGroups() {
        return groups;
    }

    public void joinGroup(String groupName, StudentDto studentDto){
        groups.get(groupName).add(studentDto);
    }
}
