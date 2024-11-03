package com.university.factory;

import com.university.evaluation.*;
import com.university.file.InformationExtractor;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class testEvaluationFactory {
    @Test
    public void testEvaluation() {

            InformationExtractor myTestInformationExtractor = new InformationExtractor();
            ArrayList<String[]> testDataList = myTestInformationExtractor.extractFileData("src/main/resources/test2.csv");
            EvaluationFactory testEvaluationFactory = new EvaluationFactory();
            ArrayList<Evaluation> testEvaluationList = testEvaluationFactory.createSelfList(testDataList);

            Evaluation evaluation1 = new WrittenExam("Segundo Parcial", "Math", "WRITTEN_EXAM", "Armando Paredes");
            evaluation1.addExerciseMark("Ej2", Integer.parseInt("7"));
            evaluation1.addExerciseMark("Ej1", Integer.parseInt("4"));
            Evaluation evaluation2 = new PracticalWork("TP3", "English", "PRACTICAL_WORK", "John Doe");
            evaluation2.addExerciseMark("Ej3", Integer.parseInt("5"));
            evaluation2.addExerciseMark("Ej2", Integer.parseInt("9"));
            evaluation2.addExerciseMark("Ej1", Integer.parseInt("2"));
            evaluation2.addExerciseMark("Ej4", Integer.parseInt("4"));
            ArrayList<Evaluation> expectedEvaluationList = new ArrayList<>();
            expectedEvaluationList.add(evaluation1);
            expectedEvaluationList.add(evaluation2);

            Evaluation evaluation3 = new FinalEvaluation("Segundo Parcial","Prog","FINAL_EXAM","Matias Ponce");
        evaluation3.addExerciseMark("Ej1", 10);
        evaluation3.addExerciseMark("Ej3", 5);
        evaluation3.addExerciseMark("Ej2", 7);

        Evaluation evaluation4 = new OralExam("Primer Parcial","Biology","ORAL_EXAM","Tomas Bregoli");
    evaluation4.addExerciseMark("Ej1", 9);
        expectedEvaluationList.add(evaluation3);
        expectedEvaluationList.add(evaluation4);
        assertTrue(expectedEvaluationList.contains(testEvaluationList.getFirst()));
        assertTrue(expectedEvaluationList.contains(testEvaluationList.get(1)));
        assertTrue(expectedEvaluationList.contains(testEvaluationList.get(2)));
        assertTrue(expectedEvaluationList.contains(testEvaluationList.getLast()));
        Evaluation testEvaluation1 = testEvaluationList.getFirst();
        Evaluation testEvaluation2 = testEvaluationList.get(1);
        Evaluation testEvaluation3 = testEvaluationList.get(2);
        Evaluation testEvaluation4 = testEvaluationList.getLast();
        assertTrue(evaluation4.getExerciseMap().equals(testEvaluation1.getExerciseMap()));
        assertTrue(evaluation1.getExerciseMap().equals(testEvaluation2.getExerciseMap()));
        assertTrue(evaluation2.getExerciseMap().equals(testEvaluation3.getExerciseMap()));
        assertTrue(evaluation3.getExerciseMap().equals(testEvaluation4.getExerciseMap()));


    }

    @Test
    public void testEquals(){
        Evaluation evaluation1 = new OralExam("a", "b", "c", "d");
        Evaluation evaluation2 = new OralExam("a", "b", "c", "d");
        Evaluation evaluation3 = new WrittenExam("a", "b", "c", "d");
        Evaluation evaluation4 = new WrittenExam("a", "b", "c", "d");
        assertTrue(evaluation1.equals(evaluation2));
        assertTrue(evaluation3.equals(evaluation4));
    }

    @Test
    public void testContainsKey(){
        HashMap<Evaluation, String> mapToTest = new HashMap<>();
        Evaluation evaluation1 = new OralExam("a", "b", "c", "d");
        Evaluation evaluation2 = new OralExam("a", "b", "c", "d");

        mapToTest.put(evaluation1, "a");
        assertTrue(mapToTest.containsKey(evaluation2));
    }
}
