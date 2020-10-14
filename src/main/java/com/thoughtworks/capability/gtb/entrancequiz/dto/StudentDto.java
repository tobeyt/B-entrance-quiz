package com.thoughtworks.capability.gtb.entrancequiz.dto;


// GTB: DTO对象不必要
public class StudentDto {
    private int id;
    private String name;

    public StudentDto(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // GTB: 方法顺序，无参构造应该在前
    public StudentDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
