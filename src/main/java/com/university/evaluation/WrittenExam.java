package com.university.evaluation;

import java.util.HashMap;

public class WrittenExam extends Evaluation{
    private HashMap<String, Integer> exerciseMap = new HashMap<String, Integer>();

    public WrittenExam(String name, String subject, String type, String student){
        super(name, subject, type, student);
    }

    @Override
    public Integer getGrade() {
        Integer grade = 0;
        for (Integer exerciseMark : exerciseMap.values()){
            grade += exerciseMark;
        }
        grade /= exerciseMap.size();
        return grade;
    }


}
