package com.university.subject;

import com.university.student.Student;

import java.util.ArrayList;

public class Subject {
    private String name;
    private ArrayList<Student> studentsList = new ArrayList<Student>();

    public Subject(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public ArrayList<Student> getStudentsList(){
        return studentsList;
    }

    public void addStudent(Student student){
        if (!studentsList.contains(student)) {
            studentsList.add(student);
        }
    }
}
