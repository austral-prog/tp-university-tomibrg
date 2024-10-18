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
            TreeMap<String, HashMap<String, HashMap<String, Evaluation>>> evaluationMap = new TreeMap<>(myUniversity.getEvaluationMap());
            for (String subject : evaluationMap.keySet()) {
                TreeMap<String, HashMap<String, Evaluation>> studentKeyEvalautionMap = new TreeMap<>(evaluationMap.get(subject));

                for(String student : studentKeyEvalautionMap.keySet()){
                    HashMap<String, Evaluation> evaluationNameMap = studentKeyEvalautionMap.get(student);

                    for(String evaluationName: evaluationNameMap.keySet()) {
                        Double average = averageGrade(evaluationNameMap.get(evaluationName));// guarda aca. Tenes que revisar si pasas por todas las evaluaciones de un alumno
                        solutionWriter.write(subject + "," + evaluationName + "," + student + "," + average.toString() + "\n");
                    }
                }
            }
            solutionWriter.close();
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    private Double averageGrade(Evaluation evaluation) {
        Integer average = 0;
        for(ArrayList<Integer> numList : evaluation.getExerciseMap().values()){

            for (Integer num : numList){
                average+= num;
            }
        }
        Double averageToReturn= (double) average/evaluation.getExerciseMap().size();
        return  averageToReturn;
    }
}

