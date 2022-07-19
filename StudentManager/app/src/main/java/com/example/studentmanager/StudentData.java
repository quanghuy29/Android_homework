package com.example.studentmanager;

import java.util.ArrayList;
import java.util.List;

public class StudentData {
    public static List<StudentModel> getStudentData(){
        List<StudentModel> list = new ArrayList<>();

        StudentModel student1 = new StudentModel("20180000", "Bui Quang Huy", "Xin chao. Ban an com chua", "12:30 PM");
        StudentModel student2 = new StudentModel("20180001", "Bui Quang Huy", "Xin chao. Ban an com chua", "12:30 PM");
        StudentModel student3 = new StudentModel("20180002", "Bui Quang Huy", "Xin chao. Ban an com chua", "12:30 PM");
        StudentModel student4 = new StudentModel("20180003", "Bui Quang Huy", "Xin chao. Ban an com chua", "12:30 PM");
        StudentModel student5 = new StudentModel("20180004", "Bui Quang Huy", "Xin chao. Ban an com chua", "12:30 PM");
        StudentModel student6 = new StudentModel("20180005", "Bui Quang Huy", "Xin chao. Ban an com chua", "12:30 PM");
        StudentModel student7 = new StudentModel("20180006", "Bui Quang Huy", "TTCK.", "12:30 PM");

        list.add(student1);
        list.add(student2);
        list.add(student3);
        list.add(student4);
        list.add(student5);
        list.add(student6);
        list.add(student7);

        return list;
    }
}
