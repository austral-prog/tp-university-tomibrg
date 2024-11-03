package com.university.evaluation;

import java.util.HashMap;

public class OralExam extends Evaluation{


    public OralExam(String name, String subject, String type, String student){
        super(name, subject, type, student);
    }

    @Override
    public Double getGrade() {
        Double grade = 0.0;
        for (Integer exerciseMark : exerciseMap.values()){
            grade = Double.valueOf(exerciseMark);
        }
        return grade;

    }
}
