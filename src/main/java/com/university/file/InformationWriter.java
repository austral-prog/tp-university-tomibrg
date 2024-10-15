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
            University2 university2 = new University2("Austral");
            File solution = new File("src\\main\\resources\\solution2.csv");
            FileWriter solutionWriter = new FileWriter("src\\main\\resources\\solution2.csv"); //Si falla fijate aca.
            solutionWriter.write("Subject_Name,Evaluation_Name,Student_Name,Grade\n");
            HashMap<String, HashMap<String, Evaluation>> evaluationMap = university2.getEvaluationMap();
            for (String subject : evaluationMap.keySet()) {

            }
            solutionWriter.close();
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    private Integer averageGrade(Evaluation evaluation) {
        Collection<String> toMakeAverage = null;
        Integer average = 0;
        for (String number : toMakeAverage) {
            int num = Integer.parseInt(number);
            average += num;
        }
        average /= toMakeAverage.size();
        return average;
    }
}

