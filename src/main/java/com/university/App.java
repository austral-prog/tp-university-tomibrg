package com.university;

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
        myUniversity.makeAllHashMapsAndList(dataList);
        InformationWriter myInformationWriter = new InformationWriter();
        InformationProcessor myInformationProcessor = new InformationProcessor();
        ArrayList<ArrayList<String>> studentToWriteList = myInformationProcessor.makeListOfStudentToWrite(myUniversity);
        myInformationWriter.writeData(studentToWriteList);


    }

    public static void main2(String[] args){
        InformationExtractor myInformationExtractor = new InformationExtractor();
        University myUniversity = new University("Austral");
        ArrayList<String[]> dataList = myInformationExtractor.extractFileData("src/main/resources/input_2.csv");
        myUniversity.makeAllHashMapsAndList(dataList);
        InformationWriter myInformationWriter = new InformationWriter();
        myInformationWriter.writeData2(myUniversity);
    }
}
