package com.university.evaluation;

import java.text.DecimalFormat;
import java.util.HashMap;

public class PracticalWork extends Evaluation{



    public PracticalWork(String name, String subject, String type, String student){
        super(name, subject, type, student);
    }

    @Override
    public Double getGrade() {
        Double grade = 0.0;
        for (Integer exerciseMark : exerciseMap.values()){
            grade = Double.valueOf(exerciseMark);
        }
        DecimalFormat formatNumber = new DecimalFormat("#.00");
        return Double.parseDouble(formatNumber.format(grade));
    }
}
