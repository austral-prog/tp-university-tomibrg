package com.university.testExaminator;

import com.university.evaluation.examinator.Examinator;
import com.university.evaluation.helper.ClassConnector;
import com.university.evaluation.helper.CriteriaSetter;
import com.university.file.InformationExtractor;
import com.university.university.University;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class testExamiantor {

    @Test
    public void testExamine(){
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

        Examinator myExaminator = new Examinator();
        ArrayList<ArrayList<String>> testExaminedStudentList = myExaminator.examine(myUniversity);

        ArrayList<ArrayList<String>> expectedExaminedStudentList = new ArrayList<>();

        ArrayList<String> listToAdd1 = new ArrayList<>();
        listToAdd1.add("Math");
        listToAdd1.add("Armando Paredes");
        listToAdd1.add("F");

        ArrayList<String> listToAdd2 = new ArrayList<>();
        listToAdd2.add("English");
        listToAdd2.add("John Doe");
        listToAdd2.add("F");

        ArrayList<String> listToAdd3 = new ArrayList<>();
        listToAdd3.add("Literature");
        listToAdd3.add("Rodolfo Pituta");
        listToAdd3.add("F");

        expectedExaminedStudentList.add(listToAdd1);
        expectedExaminedStudentList.add(listToAdd2);
        expectedExaminedStudentList.add(listToAdd3);

        assertTrue(testExaminedStudentList.contains(expectedExaminedStudentList.getFirst()));
        assertTrue(testExaminedStudentList.contains(expectedExaminedStudentList.get(1)));
        assertTrue(testExaminedStudentList.contains(expectedExaminedStudentList.getLast()));
    }
}
