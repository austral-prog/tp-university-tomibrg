package com.university.subject;

import com.university.person.Student;

import java.util.ArrayList;

public class Subject {
    private String name;
    private ArrayList<String> studentsList = new ArrayList<String>();

    public Subject(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public ArrayList<String> getStudentsList(){
        return studentsList;
    }

    public void addStudent(String student){
        if (!studentsList.contains(student)) {
            studentsList.add(student);
        }
    }

    @Override
    public boolean equals(Object other){
        boolean returnStatement = false;
        Subject subject = (Subject) other;

        if (subject.getName().equals(this.getName())){
            returnStatement = true;
        }
        return returnStatement;
    }


}
