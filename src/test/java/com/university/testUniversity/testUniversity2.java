package com.university.testUniversity;

import com.university.evaluation.Evaluation;
import com.university.file.InformationExtractor;
import com.university.person.Student;
import com.university.subject.Subject;
import com.university.university.University2;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testUniversity2 {

    @Test
    public void testDataList(){
        InformationExtractor myInformationExtractor = new InformationExtractor();
        ArrayList<String[]> toBeTestedDataList = myInformationExtractor.extractFileData("src/main/resources/test2.csv");
        ArrayList<String[]> expectedDataList = new ArrayList<>();
            String[] stringList = {"Armando Paredes","Math","WRITTERN_EXAM","Segundo Parcial","Ej2","7"};
            expectedDataList.add(stringList);


        assertEquals(expectedDataList.get(0).length, toBeTestedDataList.get(0).length);
        for (int i = 0; i < expectedDataList.size(); i++) {
            for (int j = 0; j < expectedDataList.get(i).length; j++) {
                assertEquals(expectedDataList.get(i)[j], toBeTestedDataList.get(i)[j]);
            }

        }
    }
    @Test
    public void testMakeAllMapsAndListsU2(){
        University2 myUniversity = new University2("Austral");
        InformationExtractor myInformationExtractor = new InformationExtractor();
        ArrayList<String[]> dataList = myInformationExtractor.extractFileData("src/main/resources/test2.csv");
        myUniversity.makeAllHashMapsAndList(dataList);
        HashMap<String, Student> expectedStudentMap = new HashMap<>();

        expectedStudentMap.put("Armando Paredes", new Student("Armando Paredes"));
       

        assertEquals(expectedStudentMap, myUniversity.getStudentMap());

        HashMap<String, Subject> expectedSubjectMap = new HashMap<>();


            expectedSubjectMap.put("Math", new Subject("Math"));


        assertEquals(expectedSubjectMap, myUniversity.getSubjectMap());

        HashMap<String, HashMap<String, HashMap<String, Evaluation>>> expectedEvaluationMap = new HashMap<>();
        HashMap<String, HashMap<String, Evaluation>> toBePutInStudentExpectedMap = new HashMap<>();
        HashMap<String, Evaluation> toBePutInEvaluationMap = new HashMap<>();
        toBePutInEvaluationMap.put("Segundo Parcial", new Evaluation("Segundo Parcial","Math", "WRITTERN_EXAM", new Student("Armando Paredes")));
        toBePutInStudentExpectedMap.put("Armando Paredes", toBePutInEvaluationMap);

        expectedEvaluationMap.put("Math", toBePutInStudentExpectedMap);
        assertEquals(expectedEvaluationMap, myUniversity.getEvaluationMap());
        HashMap<String, ArrayList<Double>> expectedExerciseMap = new HashMap<>();
        ArrayList<Double> toBePutInExpectedExamMap = new ArrayList<>();
        toBePutInExpectedExamMap.add(7.0);
        expectedExerciseMap.put("Segundo Parcial",toBePutInExpectedExamMap);

    }

}
