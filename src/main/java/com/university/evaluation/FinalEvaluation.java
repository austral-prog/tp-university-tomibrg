package com.university.evaluation;

import java.util.ArrayList;
import java.util.HashMap;

public class FinalEvaluation extends Evaluation{




    public FinalEvaluation(String name, String subject, String type, String student){
        super(name, subject, type, student);
    }

    @Override
    public Double getGrade() {
        Double grade = 0.0;
        for (Integer exerciseMark : exerciseMap.values()){
            grade += exerciseMark;
        }
        return grade;
    }
}
