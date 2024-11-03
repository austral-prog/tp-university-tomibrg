package com.university.testHelper;

import com.university.evaluation.Evaluation;
import com.university.evaluation.FinalEvaluation;
import com.university.evaluation.PracticalWork;
import com.university.evaluation.WrittenExam;
import com.university.evaluation.helper.ClassConnector;
import com.university.evaluation.helper.CriteriaSetter;
import com.university.file.InformationExtractor;
import com.university.person.Student;
import com.university.subject.Subject;
import com.university.university.University;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class testClassConnector {

    @Test
    public void testConnectClass(){
        University myUniversity = new University("Austral");
        InformationExtractor myInformationExtractor = new InformationExtractor();
        ArrayList<String[]> dataList = myInformationExtractor.extractFileData("src/main/resources/test1_1.csv");
        myUniversity.makeSubjectList(dataList);
        myUniversity.makeStudentList(dataList);
        CriteriaSetter myCriteriaSetter = new CriteriaSetter();
        ArrayList<String[]> criteriaDataList = myInformationExtractor.extractFileData("src/main/resources/test3_1.csv");
        myCriteriaSetter.setCriteria(criteriaDataList,myUniversity);

        ArrayList<String[]> evaluationDataList = myInformationExtractor.extractFileData("src/main/resources/test2_2.csv");
        myUniversity.makeEvaluationList(evaluationDataList);

        ClassConnector myClassConnector = new ClassConnector();
        myClassConnector.connectClass(myUniversity);

        ArrayList<Student> testStudentList = myUniversity.getStudentList();

        HashMap<Subject, ArrayList<Evaluation>> expectedEvaluationMap1 = new HashMap<>();
        Subject math = new Subject("Math");
        ArrayList<String> evaluationList1 = new ArrayList<>();
        evaluationList1.add("TP1");
        evaluationList1.add("TP2");
        evaluationList1.add("TP3");
        math.addCriteria(evaluationList1, "AVERAGE_ABOVE_VALUE");

        ArrayList<String> evaluationList2 = new ArrayList<>();
        evaluationList2.add("Examen Final");
        math.addCriteria(evaluationList2,"MAX_ABOVE_VALUE");

        Subject english = new Subject("English");
        english.addCriteria(evaluationList2,"MAX_ABOVE_VALUE");
        ArrayList<String> evaluationList3 = new ArrayList<>();
        evaluationList3.add("Primer Parcial");
        evaluationList3.add("Segundo Parcial");

        Evaluation evaluation1 = new WrittenExam("Primer Parcial","Math","WRITTEN_EXAM","Armando Paredes");
        Evaluation evaluation2 = new WrittenExam("Segundo Parcial","Math","WRITTEN_EXAM","Armando Paredes");
        Evaluation evaluation3 = new FinalEvaluation("Examen Final","Math","FINAL_EXAM","Armando Paredes");

        ArrayList<Evaluation> evaluations = new ArrayList<>();
        evaluations.add(evaluation1);
        evaluations.add(evaluation2);
        evaluations.add(evaluation3);
        expectedEvaluationMap1.put(math,evaluations);

        Evaluation evaluation4 = new PracticalWork("TP3","English","PRACTICAL_WORK","John Doe");
        Evaluation evaluation5 = new PracticalWork("TP1","English","PRACTICAL_WORK","John Doe");
        Evaluation evaluation6 = new PracticalWork("TP2","English","PRACTICAL_WORK","John Doe");
        Evaluation evaluation7 = new FinalEvaluation("Examen Final","English","FINAL_EXAM","John Doe");

        ArrayList<Evaluation> evaluations2 = new ArrayList<>();
        evaluations2.add(evaluation4);
        evaluations2.add(evaluation5);
        evaluations2.add(evaluation6);
        evaluations2.add(evaluation7);

        HashMap<Subject, ArrayList<Evaluation>> expectedEvaluationMap2 = new HashMap<>();
        expectedEvaluationMap2.put(english, evaluations2);

        assertTrue(expectedEvaluationMap1.get(math).contains(testStudentList.get(1).getEvaluationMap().get(math).getFirst()));
        assertTrue(expectedEvaluationMap1.get(math).contains(testStudentList.get(1).getEvaluationMap().get(math).get(1)));
        assertTrue(expectedEvaluationMap1.get(math).contains(testStudentList.get(1).getEvaluationMap().get(math).getLast()));
        assertTrue(expectedEvaluationMap2.get(english).contains(testStudentList.getFirst().getEvaluationMap().get(english).getFirst()));
        assertTrue(expectedEvaluationMap2.get(english).contains(testStudentList.getFirst().getEvaluationMap().get(english).get(1)));
        assertTrue(expectedEvaluationMap2.get(english).contains(testStudentList.getFirst().getEvaluationMap().get(english).getLast()));

        Subject subject = new Subject("Literature");
        HashMap<Subject, ArrayList<Evaluation>> expectedEvaluationMap3 = new HashMap<>();
        expectedEvaluationMap3.put(subject, new ArrayList<Evaluation>());
        assertTrue(expectedEvaluationMap3.equals(testStudentList.getLast().getEvaluationMap()));

    }
}
