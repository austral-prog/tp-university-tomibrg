package com.university.file;


import com.university.evaluation.Evaluation;
import com.university.university.University;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class InformationWriter {

    public void writeData(ArrayList<ArrayList<String>> studentStringList) {
        try {
            FileWriter solutionWriter = new FileWriter("src\\main\\resources\\solution.csv"); //Si falla fijate aca.
            solutionWriter.write("Student_Name,Course_Count\n");

            for (ArrayList<String> student : studentStringList) {
                solutionWriter.write(student.getFirst() + "," + student.getLast() + "\n");
            }
            solutionWriter.close();
        }
        catch (IOException i) {
            i.printStackTrace();
        }
    }


    public void writeData2(University myUniversity) {
        try {

            File solution = new File("src\\main\\resources\\solution2.csv");
            FileWriter solutionWriter = new FileWriter("src\\main\\resources\\solution2.csv"); //Si falla fijate aca.
            solutionWriter.write("Subject_Name,Evaluation_Name,Student_Name,Grade");
            ArrayList<Evaluation> evaluationList = myUniversity.getEvaluationList();
            InformationProcessor myInformationProcessor = new InformationProcessor();
            ArrayList<ArrayList<String>> listToWrite = myInformationProcessor.makeListToWrite(evaluationList);
            for(ArrayList<String> lineToWrite : listToWrite) {
                String subject = lineToWrite.getFirst();
                String evaluationName = lineToWrite.get(1);
                String studentName = lineToWrite.get(2);
                String grade = lineToWrite.getLast();
                solutionWriter.write("\n" + subject + "," + evaluationName + "," + studentName +"," + grade);
            }

            solutionWriter.close();
        } catch (IOException i) {
            i.printStackTrace();
        }
    }


    }



