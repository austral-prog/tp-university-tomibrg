package com.university.evaluation.helper;

import com.university.subject.Subject;
import com.university.university.University;

import java.util.ArrayList;

public class CriteriaSetter {

    public void setCriteria(ArrayList<String[]> dataList, University university){
        ArrayList<Subject> subjectList = university.getSubjectList();
        for (Subject subject : subjectList){
            String subjectName = subject.getName();
            for(String[] lineList : dataList){
                if (subjectName.equalsIgnoreCase(lineList[0])){
                    ArrayList<String> evaluations = new ArrayList<>();
                    for (int i = 0; i < lineList.length; i++) {
                        if (i >= 3){
                            evaluations.add(lineList[i]);
                        }
                    }
                    subject.addCriteria(evaluations, lineList[1]);
                }
            }
        }
    }
}
