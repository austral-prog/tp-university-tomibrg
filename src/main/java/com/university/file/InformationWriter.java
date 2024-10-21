package com.university.file;

import com.university.evaluation.Evaluation;
import com.university.person.Student;
import com.university.university.University;
import com.university.university.University2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;

public class InformationWriter {

    public void writeData(University university) {
        try {
            File solution = new File("src\\main\\resources\\students.csv");
            FileWriter solutionWriter = new FileWriter("src\\main\\resources\\solution.csv"); //Si falla fijate aca.
            solutionWriter.write("Student_Name,Course_Count\n");
            String[] StudentListToMakeArrayList = university.getStudentMap().keySet().toArray(new String[0]);
            ArrayList<String> studentList = new ArrayList<String>();
            for (String student : StudentListToMakeArrayList) {
                studentList.add(student);
            }

            Collections.sort(studentList);

            for (String student : studentList) {
                Integer studentSubjecAmount = university.getStudentMap().get(student).getCourseList().size();

                solutionWriter.write(student + "," + studentSubjecAmount.toString() + "\n");
            }
            solutionWriter.write("\n");
            solutionWriter.close();
        } catch (IOException i) {
            i.printStackTrace();
        }
    }


    public void writeData2(University2 myUniversity) {
        try {

            File solution = new File("src\\main\\resources\\solution2.csv");
            FileWriter solutionWriter = new FileWriter("src\\main\\resources\\solution2.csv"); //Si falla fijate aca.
            solutionWriter.write("Subject_Name,Evaluation_Name,Student_Name,Grade\n");
            ArrayList<Evaluation> evaluationList = myUniversity.getEvaluationList();
            InformationProcessor myInformationProcessor = new InformationProcessor();
            ArrayList<ArrayList<String>> listToWrite = myInformationProcessor.makeListToWrite(evaluationList);
            for(ArrayList<String> lineToWrite : listToWrite) {
                String subject = lineToWrite.getFirst();
                String evaluationName = lineToWrite.get(1);
                String studentName = lineToWrite.get(2);
                String grade = lineToWrite.getLast();
                solutionWriter.write(subject + "," + evaluationName + "," + studentName +"," + grade + "\n");
            }

            solutionWriter.close();
        } catch (IOException i) {
            i.printStackTrace();
        }
    }


    }



