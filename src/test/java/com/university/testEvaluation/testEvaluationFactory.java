package com.university.testEvaluation;

import com.university.evaluation.Evaluation;
import com.university.evaluation.EvaluationFactory;
import com.university.file.InformationExtractor;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class testEvaluationFactory {
    @Test
    public void testEvaluation() {

            InformationExtractor myTestInformationExtractor = new InformationExtractor();
            ArrayList<String[]> testDataList = myTestInformationExtractor.extractFileData("src/main/resources/test2.csv");


            EvaluationFactory testEvaluationFactory = new EvaluationFactory();
            ArrayList<Evaluation> testEvaluationList = testEvaluationFactory.createEvaluationList(testDataList);
            Evaluation evaluation1 = new Evaluation("Segundo Parcial", "Math", "WRITTEN_EXAM", "Armando Paredes");
            evaluation1.addExerciseMark("Ej2", Integer.parseInt("7"));
            evaluation1.addExerciseMark("Ej1", Integer.parseInt("4"));

            Evaluation evaluation2 = new Evaluation("TP3", "English", "PRACTICAL_WORK", "John Doe");
            evaluation2.addExerciseMark("Ej3", Integer.parseInt("5"));
            evaluation2.addExerciseMark("Ej2", Integer.parseInt("9"));
            ArrayList<Evaluation> expectedEvaluationList = new ArrayList<>();
            expectedEvaluationList.add(evaluation1);
            expectedEvaluationList.add(evaluation2);
            assertEquals(expectedEvaluationList.getFirst(), testEvaluationList.getFirst());
            assertEquals(expectedEvaluationList.getLast(), testEvaluationList.getLast());
            Evaluation testEvaluation1 = testEvaluationList.getFirst();
            Evaluation testEvaluation2 = testEvaluationList.getLast();
            assertEquals(evaluation1.getExerciseMap().get("Ej2"), testEvaluation1.getExerciseMap().get("Ej2"));
            assertEquals(evaluation1.getExerciseMap().get("Ej1"), testEvaluation1.getExerciseMap().get("Ej1"));
            assertEquals(evaluation2.getExerciseMap().get("Ej3"), testEvaluation2.getExerciseMap().get("Ej3"));
            assertEquals(evaluation2.getExerciseMap().get("Ej2"), testEvaluation2.getExerciseMap().get("Ej2"));


    }

    @Test
    public void testEquals(){
        Evaluation evaluation1 = new Evaluation("a", "b", "c", "d");
        Evaluation evaluation2 = new Evaluation("a", "b", "c", "d");
        assertTrue(evaluation1.equals(evaluation2));
    }

    @Test
    public void testContainsKey(){
        HashMap<Evaluation, String> mapToTest = new HashMap<>();
        Evaluation evaluation1 = new Evaluation("a", "b", "c", "d");
        Evaluation evaluation2 = new Evaluation("a", "b", "c", "d");

        mapToTest.put(evaluation1, "a");
        assertTrue(mapToTest.containsKey(evaluation2));
    }
}
