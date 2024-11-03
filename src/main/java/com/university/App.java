package com.university;

import com.university.evaluation.examinator.Examinator;
import com.university.evaluation.helper.ClassConnector;
import com.university.evaluation.helper.CriteriaSetter;
import com.university.file.InformationExtractor;
import com.university.file.InformationProcessor;
import com.university.file.InformationWriter;
import com.university.university.University;

import java.util.ArrayList;


public class App {
    public static void main(String[] args) {
        University myUniversity = new University("Austral");
        InformationExtractor myInformationExtractor = new InformationExtractor();
        ArrayList<String[]> dataList = myInformationExtractor.extractFileData("src/main/resources/input.csv");
        myUniversity.makeSubjectList(dataList);
        myUniversity.makeStudentList(dataList);
        InformationWriter myInformationWriter = new InformationWriter();
        InformationProcessor myInformationProcessor = new InformationProcessor();
        ArrayList<ArrayList<String>> studentToWriteList = myInformationProcessor.makeListOfStudentToWrite(myUniversity);
        myInformationWriter.writeData(studentToWriteList);

        ArrayList<String[]> evaluationDataList = myInformationExtractor.extractFileData("src/main/resources/input_2.csv");
        myUniversity.makeEvaluationList(evaluationDataList);
        myInformationWriter.writeData2(myUniversity);

        ArrayList<String[]> criteriaList = myInformationExtractor.extractFileData("src/main/resources/input_3.csv");
        CriteriaSetter myCriteriaSetter = new CriteriaSetter();
        myCriteriaSetter.setCriteria(criteriaList,myUniversity);

        ClassConnector myClassConnector = new ClassConnector();
        myClassConnector.connectClass(myUniversity);

        Examinator myExaminator = new Examinator();
        ArrayList<ArrayList<String>>examinedStudentList = myExaminator.examine(myUniversity);
        ArrayList<String> examinedStudentListToWrite = myInformationProcessor.makeListOfExaminedStudentsToWrite(examinedStudentList);
        myInformationWriter.writeData3(examinedStudentListToWrite);
    }
}
