package com.university.evaluation;

import com.university.person.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class Evaluation {
     private String subject;
    private String type;
    private String  name;
    private HashMap<String, ArrayList<Integer>> exerciseMap = new HashMap<String, ArrayList<Integer>>();
    private String grade;
    private String student;

    public Evaluation(String name, String subject,String type, String student){
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

    public HashMap<String, ArrayList<Integer>> getExerciseMap(){
        return exerciseMap;
    }

    public void addExerciseMark(String exam, Integer mark){
        if (exerciseMap.containsKey((exam))){
            exerciseMap.get(exam).add(mark);
        }
        else{
            ArrayList<Integer> toPutArray = new ArrayList<>();
            toPutArray.add(mark);
            exerciseMap.put(exam, toPutArray);
        }
    }

    public String getGrade(){
        return grade;
    }

    public String getStudent(){
        return student;
    }

    @Override
    public boolean equals(Object o) {
        boolean returnStatement = false;

        Evaluation other = (Evaluation) o;
        if (this.getName().equals( other.getName()) & this.student.equals(other.getStudent()) & this.subject.equals(other.getSubject()) & this.type.equals(other.getType())) {
            returnStatement = true;
        }
        return returnStatement;
    }

    @Override
    public int hashCode(){
        return Objects.hash(name, student,subject, type);
    }
}
