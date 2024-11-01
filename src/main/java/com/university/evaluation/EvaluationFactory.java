package com.university.evaluation;

import com.university.factory.Factory;

import java.util.*;

public class EvaluationFactory implements Factory <Evaluation> {
    HashMap<Evaluation, ArrayList<ArrayList<String>>> evaluationMap = new HashMap<>();

    @Override
    public ArrayList<Evaluation> createSelfList(ArrayList<String[]> DataList) {

        for (String[] lineList : DataList) {
            String studentName = lineList[0];
            String subject = lineList[1];
            String evaluationType = lineList[2];
            String evaluationName = lineList[3];
            String exercise = lineList[4];
            String grade = lineList[5];
            ArrayList<String> exerciseList = new ArrayList<>();
            exerciseList.add(exercise);
            exerciseList.add(grade);

            if (evaluationType.toLowerCase().contains("final")) {
                FinalEvaluation finalEvaluationToCompare = new FinalEvaluation(evaluationName, subject, evaluationType, studentName);
                putInMap(finalEvaluationToCompare, exerciseList);
            } else if (evaluationType.equalsIgnoreCase("PRACTICAL_WORK")) {
                PracticalWork practicalEvaluationToCompare = new PracticalWork(evaluationName, subject, evaluationType, studentName);
                putInMap(practicalEvaluationToCompare, exerciseList);
            } else if (evaluationType.equalsIgnoreCase("ORAL_EXAM")) {
                OralExam oralEvaluationToCompare = new OralExam(evaluationName, subject, evaluationType, studentName);
                putInMap(oralEvaluationToCompare, exerciseList);
            } else if (evaluationType.equalsIgnoreCase("WRITTEN_EXAM")) {
                WrittenExam writtenEvaluationToCompare = new WrittenExam(evaluationName, subject, evaluationType, studentName);
                putInMap(writtenEvaluationToCompare, exerciseList);
            }
        }
        return makeMapToList(evaluationMap);
    }

    private void putInMap(Evaluation evaluation, ArrayList<String> exerciseList){
        if (!evaluationMap.containsKey(evaluation)){
            evaluationMap.put(evaluation, new ArrayList<ArrayList<String>>());
            evaluationMap.get(evaluation).add(exerciseList);
        }
        else{
            evaluationMap.get(evaluation).add(exerciseList);
        }
    }

    private ArrayList<Evaluation> makeMapToList(HashMap<Evaluation, ArrayList<ArrayList<String>>> evaluationMap){
        ArrayList<Evaluation> evaluationList = new ArrayList<>(); //Si la grade esta rara, fijate aca. puede que el orden de las notas este mal.
        for (Evaluation evaluation : evaluationMap.keySet()){
            ArrayList<ArrayList<String>> exerciseLists = evaluationMap.get(evaluation);
            for (ArrayList<String> exercise : exerciseLists){
                evaluation.addExerciseMark(exercise.getFirst(), Integer.parseInt(exercise.getLast()));
            }
            evaluationList.add(evaluation);
        }
        return evaluationList;
    }
}
