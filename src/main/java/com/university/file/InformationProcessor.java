package com.university.file;


import com.university.evaluation.Evaluation;
import com.university.person.Student;
import com.university.university.University;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class InformationProcessor {

    public ArrayList<ArrayList<String>> makeListToWrite(ArrayList<Evaluation> evaluationList) {
        ArrayList<ArrayList<String>> studentEvaluationDataList = new ArrayList<>();
        for (Evaluation evaluation : evaluationList) {
            ArrayList<String> subList = new ArrayList<>();
            subList.add(evaluation.getSubject());
            subList.add(evaluation.getName());
            subList.add(evaluation.getStudent());
            Integer averageGrade = evaluation.getGrade();
            subList.add(averageGrade.toString());
            studentEvaluationDataList.add(subList);
        }
        orderList(studentEvaluationDataList);
        return studentEvaluationDataList;
    }



    private ArrayList<ArrayList<String>> orderList(ArrayList<ArrayList<String>> studentEvaluationDataList){
        Collections.sort(studentEvaluationDataList, (list1, list2) -> {
            int comparacion = list1.get(0).compareTo(list2.get(0));
            if (comparacion == 0){
                comparacion = list1.get(1).compareTo(list2.get(1));
                if (comparacion == 0){
                    comparacion = list1.get(2).compareTo(list2.get(2));
                }
            }
            return comparacion;
        });
        return studentEvaluationDataList;
    }

    public ArrayList<ArrayList<String>> makeListOfStudentToWrite(University university){
        ArrayList<ArrayList<String>> studentStringList = new ArrayList<>();
        for (Student student : university.getStudentList()){
            ArrayList<String> listToAdd = new ArrayList<>();
            listToAdd.add(student.getName());
            int courseCount = student.getCourseList().size();
            listToAdd.add(Integer.toString(courseCount));
            studentStringList.add(listToAdd);
        }
         Collections.sort(studentStringList, new Comparator<ArrayList<String>>() {
            @Override
            public int compare(ArrayList<String> o1, ArrayList<String> o2) {        //si no esta bien el orden, mira aca.
                return o1.getFirst().compareTo(o2.getFirst());
            }
        });
        return studentStringList;
    }

}
