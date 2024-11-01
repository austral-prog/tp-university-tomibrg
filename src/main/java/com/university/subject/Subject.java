package com.university.subject;

import com.university.factory.Factorable;
import com.university.person.Student;

import java.util.ArrayList;
import java.util.HashMap;

public class Subject implements Factorable {
    private String name;
    private ArrayList<String> studentsList = new ArrayList<String>();
    private HashMap<String, ArrayList<String>> criteriaMap;
    private ArrayList<String> classroomList = new ArrayList<>();

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

    public ArrayList<String> getClassroomList(){
        return classroomList;
    }

    public void addClassroom(String classroom){
        if (!classroomList.contains(classroom)) {
            classroomList.add(classroom);
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
