package com.thoughtworks.capability.gtb.entrancequiz.dto;


public class StudentDto {
    private int id;
    private String name;

    public StudentDto(int id, String name) {
        this.id = id;
        this.name = name;
    }

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
