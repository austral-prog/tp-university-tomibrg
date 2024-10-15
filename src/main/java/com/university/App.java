package com.university;

import com.university.file.InformationExtractor;
import com.university.file.InformationWriter;
import com.university.person.Student;
import com.university.university.University;
import com.university.university.University2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;


public class App {
    public static void main(String[] args) {
        University myUniversity = new University("Austral");
        InformationExtractor myInformationExtractor = new InformationExtractor();
        ArrayList<String[]> dataList = myInformationExtractor.extractFileData("src/main/resources/input.csv");
        myUniversity.makeAllHashMapsAndList(dataList);
        InformationWriter myInformationWriter = new InformationWriter();
        myInformationWriter.writeData(myUniversity);
    }
    public static void main2(String[] args){
        University2 myUniversity2 = new University2("Austral2");
        InformationExtractor myInformationExtractor2 = new InformationExtractor();
        ArrayList<String[]> dataList = myInformationExtractor2.extractFileData("src/main/resources/input_2.csv");
        myUniversity2.makeAllHashMapsAndList(dataList);
        InformationWriter myInformationWriter = new InformationWriter();
        myInformationWriter.writeData2(myUniversity2);
    }
}
