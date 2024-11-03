package com.university.testHelper;

import com.university.evaluation.helper.CriteriaSetter;
import com.university.file.InformationExtractor;
import com.university.subject.Subject;
import com.university.university.University;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class testCriteriaSetter {

    @Test

    public void tesetSetCriteria(){

        University myUniversity = new University("Austral");
        InformationExtractor myInformationExtractor = new InformationExtractor();
        ArrayList<String[]> dataList = myInformationExtractor.extractFileData("src/main/resources/test3_2.csv");
        myUniversity.makeSubjectList(dataList);
        CriteriaSetter myCriteriaSetter = new CriteriaSetter();
        ArrayList<String[]> criteriaDataList = myInformationExtractor.extractFileData("src/main/resources/test3.csv");
        myCriteriaSetter.setCriteria(criteriaDataList,myUniversity);

        ArrayList<Subject> toBeTestedSubjectList = myUniversity.getSubjectList();
        ArrayList<Subject> expectedSubjectList = new ArrayList<>();
        expectedSubjectList.add(new Subject("Geography"));
        expectedSubjectList.add(new Subject("Economics"));

        ArrayList<String> evaluationList1 = new ArrayList<>();
        evaluationList1.add("TP1");
        evaluationList1.add("TP4");
        evaluationList1.add("TP2");
        evaluationList1.add("TP3");
        expectedSubjectList.getFirst().addCriteria(evaluationList1, "AVERAGE_ABOVE_VALUE");

        ArrayList<String> evaluationList2 = new ArrayList<>();
        evaluationList2.add("Examen Final");
        expectedSubjectList.getFirst().addCriteria(evaluationList2, "MAX_ABOVE_VALUE");

        ArrayList<String> evaluationList3 = new ArrayList<>();
        evaluationList3.add("Examen Final");
        expectedSubjectList.getLast().addCriteria(evaluationList3, "MAX_ABOVE_VALUE");

        ArrayList<String> evaluationList4 = new ArrayList<>();
        evaluationList4.add("Primer Parcial");
        evaluationList4.add("Segundo Parcial");
        expectedSubjectList.getLast().addCriteria(evaluationList4, "MIN_ABOVE_VALUE");

        HashMap<String, ArrayList<String>> expectedHashMap1 = new HashMap<>();
        expectedHashMap1.put("AVERAGE_ABOVE_VALUE", evaluationList1);
        expectedHashMap1.put("MAX_ABOVE_VALUE", evaluationList2);

        HashMap<String, ArrayList<String>> expectedHashMap2 = new HashMap<>();
        expectedHashMap2.put("MAX_ABOVE_VALUE", evaluationList3);
        expectedHashMap2.put("MIN_ABOVE_VALUE", evaluationList4);


        assertTrue(expectedHashMap1.equals(expectedSubjectList.getFirst().getCriteria()));
        assertTrue(expectedHashMap2.equals(expectedSubjectList.get(1).getCriteria()));

        assertTrue(expectedHashMap1.equals(toBeTestedSubjectList.getFirst().getCriteria()));
        assertTrue(expectedHashMap2.equals(toBeTestedSubjectList.get(1).getCriteria()));

    }
}
