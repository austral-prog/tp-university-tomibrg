package com.university.evaluation;

import com.university.person.Student;

import java.util.ArrayList;
import java.util.HashMap;

public class Evaluation {
     String subject;
     String type;
     String  name;
     HashMap<String, ArrayList<Integer>> exerciseMap = new HashMap<String, ArrayList<Integer>>();
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
