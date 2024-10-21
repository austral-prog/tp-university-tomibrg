package com.university.file;

import com.university.evaluation.Evaluation;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;

public class InformationProcessor {

    public ArrayList<ArrayList<String>> makeListToWrite(ArrayList<Evaluation> evaluationList) {
        ArrayList<ArrayList<String>> studentEvaluationDataList = new ArrayList<>();
        for (Evaluation evaluation : evaluationList) {
            ArrayList<String> subList = new ArrayList<>();
            subList.add(evaluation.getSubject());
            subList.add(evaluation.getName());
            subList.add(evaluation.getStudent());
            Double averageGrade = getAverage(evaluation);
            subList.add(averageGrade.toString());
            studentEvaluationDataList.add(subList);
        }
        orderList(studentEvaluationDataList);
        return studentEvaluationDataList;
    }

    private Double getAverage(Evaluation evaluation) {
        Integer average = 0;
        for (ArrayList<Integer> numList : evaluation.getExerciseMap().values()) {

            for (Integer num : numList) {
                average += num;
            }
        }
        Double averageToReturn = (double) average / evaluation.getExerciseMap().size();
        DecimalFormat numberFormat = new DecimalFormat("#.0");
        return Double.parseDouble(numberFormat.format(averageToReturn));
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

}
