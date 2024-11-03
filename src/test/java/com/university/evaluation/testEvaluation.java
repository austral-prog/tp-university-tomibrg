package com.university.evaluation;

import com.university.file.InformationExtractor;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testEvaluation {

    @Test
    public void testGetGrade(){
        InformationExtractor myTestInformationExtractor = new InformationExtractor();
        ArrayList<String[]> testDataList = myTestInformationExtractor.extractFileData("src/main/resources/test2.csv");
        EvaluationFactory testEvaluationFactory = new EvaluationFactory();
        ArrayList<Evaluation> testEvaluationList = testEvaluationFactory.createSelfList(testDataList);

        assertEquals(9.0,testEvaluationList.getFirst().getGrade());
        assertEquals(5.5,testEvaluationList.get(1).getGrade());
        assertEquals(4.0,testEvaluationList.get(2).getGrade());
        assertEquals(22.0,testEvaluationList.get(3).getGrade());
    }
}
