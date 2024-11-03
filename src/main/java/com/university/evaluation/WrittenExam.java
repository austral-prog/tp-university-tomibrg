package com.university.evaluation;

import java.text.DecimalFormat;
import java.util.HashMap;

public class WrittenExam extends Evaluation{


    public WrittenExam(String name, String subject, String type, String student){
        super(name, subject, type, student);
    }

    @Override
    public Double getGrade() {
        Double grade = 0.0;
        for (Integer exerciseMark : exerciseMap.values()){
            grade += exerciseMark;
        }
        grade /= exerciseMap.size();
        DecimalFormat numberFormat = new DecimalFormat("#.00");
        return Double.parseDouble(numberFormat.format(grade));
    }


}
