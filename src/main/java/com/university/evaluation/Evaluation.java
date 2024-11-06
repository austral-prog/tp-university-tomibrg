package com.university.evaluation;

import com.university.Entity;
import com.university.factory.Factorable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Objects;

public abstract class Evaluation implements Factorable,Entity {
    private String subject;
    private String type;
    private String  name;
    public HashMap<String, Integer> exerciseMap = new LinkedHashMap<>();
    private int id;
    private String student;

    public Evaluation(String name, String subject, String type, String student){
        this.name = name;
        this.subject = subject;
        this.type = type;
        this.student = student;

    }

    public String getName(){
        return name;
    }

    public String getSubject(){
        return subject;
    }

    public String getType(){
        return type;
    }

    public HashMap<String, Integer> getExerciseMap(){
        return exerciseMap;
    }

    public void addExerciseMark(String exercise, Integer mark){
        if (!exerciseMap.containsKey((exercise))){
            exerciseMap.put(exercise, mark);
        }
    }

    public String getStudent(){
        return  student;
    }

    public abstract Double getGrade();

    @Override
    public boolean equals(Object o){
        boolean returnStatement = false;
        if (o instanceof Evaluation) {

            Evaluation other = (Evaluation) o;
            if (name.equalsIgnoreCase(other.getName()) && subject.equalsIgnoreCase(other.getSubject()) && type.equalsIgnoreCase(other.getType()) && student.equalsIgnoreCase(other.getStudent())) {
                returnStatement = true;
            }
        }
        return returnStatement;
    }

    @Override
    public int hashCode(){
        return Objects.hash(name, subject, type, student);
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
