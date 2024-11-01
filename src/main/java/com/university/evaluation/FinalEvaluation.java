package com.university.evaluation;

import java.util.ArrayList;
import java.util.HashMap;

public class FinalEvaluation extends Evaluation{

    private HashMap<String, Integer> exerciseMap = new HashMap<String, Integer>();


    public FinalEvaluation(String name, String subject, String type, String student){
        super(name, subject, type, student);
    }

    @Override
    public Integer getGrade() {
        Integer grade = 0;
        for (Integer exerciseMark : exerciseMap.values()){
            grade += exerciseMark;
        }
        return grade;
    }
}
