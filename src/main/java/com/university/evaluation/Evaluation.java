package com.university.evaluation;

import com.university.person.Student;

import java.util.ArrayList;
import java.util.HashMap;

public class Evaluation {
     String subject;
     String type;
     String  name;
     HashMap<String, ArrayList<Double>> exerciseMap = new HashMap<String, ArrayList<Double>>();
     String grade;
     Student student;

    public Evaluation(String name, String subject,String type, Student student){
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

    public HashMap<String, ArrayList<Double>> getExerciseMap(){
        return exerciseMap;
    }

    public void addExerciseMark(String exam, Double mark){
        if (exerciseMap.containsKey((exam))){
            exerciseMap.get(exam).add(mark);
        }
        else{
            ArrayList<Double> toPutArray = new ArrayList<>();
            toPutArray.add(mark);
            exerciseMap.put(exam, toPutArray);
        }
    }

    public String getGrade(){
        return grade;
    }

    public Student getStudent(){
        return student;
    }

    @Override
    public boolean equals(Object other) {
        boolean returnStatement = false;
        Evaluation evaluation = (Evaluation) other;

        if (this.getName().equals(((Evaluation) other).getName())) {
            returnStatement = true;
        }
        return returnStatement;
    }
}
