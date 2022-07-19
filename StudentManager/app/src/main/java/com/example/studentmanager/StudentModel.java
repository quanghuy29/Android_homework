package com.example.studentmanager;

public class StudentModel {
    public String studentId;
    public String name;
    public String email;
    public String birth;

    public StudentModel(String studentId, String name, String email, String birth) {
        this.studentId = studentId;
        this.name = name;
        this.email = email;
        this.birth = birth;
    }
}
