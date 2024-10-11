package com.university.file;

import com.university.person.Student;
import com.university.university.University;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

public class InformationWriter {

    public void writeData(University university){
        try {
            File solution = new File("src\\main\\resources\\students.csv");
            FileWriter solutionWriter = new FileWriter("src\\main\\resources\\solution.csv"); //Si falla fijate aca.
            solutionWriter.write("Student_Name,Course_Count\n");
            String[] StudentListToMakeArrayList = university.getStudentMap().keySet().toArray(new String[0]);
            ArrayList<String> studentList = new ArrayList<String>();
            for (String student : StudentListToMakeArrayList){
                studentList.add(student);
            }

            Collections.sort(studentList);

            for (String student : studentList) {
                Integer studentSubjecAmount = university.getStudentMap().get(student).getCourseList().size();

                solutionWriter.write(student + "," + studentSubjecAmount.toString() + "\n");
            }
            solutionWriter.write("\n");
            solutionWriter.close();
        } catch (IOException i){
            i.printStackTrace();
        }
    }
}
