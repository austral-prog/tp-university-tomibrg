package com.university.evaluation;

import com.university.person.Student;

import java.text.DecimalFormat;
import java.util.*;

public class EvaluationFactory  {



    public ArrayList<Evaluation> createEvaluationList(ArrayList<String[]> DataList) {
        HashMap<Evaluation, ArrayList<ArrayList<String>>> evaluationMap = new HashMap<>();
        for(String[] lineList : DataList){
            String studentName = lineList[0];
            String subject = lineList[1];
            String evaluationType = lineList[2];
            String evaluationName = lineList[3];
            String exercise = lineList[4];
            String grade = lineList[5];

            Evaluation evaluationComparator = new Evaluation(evaluationName, subject, evaluationType, studentName);
            ArrayList<String> subExerciseList = new ArrayList<>();
            subExerciseList.add(exercise);
            subExerciseList.add(grade);

            if (!evaluationMap.containsKey(evaluationComparator)){

                evaluationMap.put(evaluationComparator, new ArrayList<ArrayList<String>>());
                evaluationMap.get(evaluationComparator).add(subExerciseList);
            }
            else{

                evaluationMap.get(evaluationComparator).add(subExerciseList);
            }
        }

        return makeMapToList(evaluationMap);
    }

    private ArrayList<Evaluation> makeMapToList(HashMap<Evaluation, ArrayList<ArrayList<String>>> evaluationMap){
        ArrayList<Evaluation> finalEvaluationList = new ArrayList<>();
        for (Evaluation evaluation : evaluationMap.keySet()){
            ArrayList<ArrayList<String>> evaluationList = evaluationMap.get(evaluation);
            for(ArrayList<String> exerciseList : evaluationList){
                String exercise = exerciseList.getFirst();
                String grade = exerciseList.getLast();
                evaluation.addExerciseMark(exercise, Integer.parseInt(grade)); //Si algun error con el promedio, fijate aca.
            }
            finalEvaluationList.add(evaluation);
        }
        return finalEvaluationList;
    }




}
