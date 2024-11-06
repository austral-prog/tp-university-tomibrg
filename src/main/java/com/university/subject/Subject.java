package com.university.subject;

import com.university.Entity;
import com.university.factory.Factorable;
import com.university.person.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class Subject implements Factorable, Entity {
    private String name;
    private ArrayList<String> studentsList = new ArrayList<String>();
    private HashMap<String, ArrayList<String>> criteriaMap = new HashMap<>();
    private ArrayList<String> classroomList = new ArrayList<>();
    private int id;

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

    public void addCriteria(ArrayList<String> evaluationNames, String criteria){
        if(!criteriaMap.containsKey(criteria)){
            criteriaMap.put(criteria, evaluationNames);
        }
    }

    public HashMap<String, ArrayList<String>> getCriteria(){
        return criteriaMap;
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

    @Override
    public int hashCode(){
        return Objects.hash(name);
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }
}
