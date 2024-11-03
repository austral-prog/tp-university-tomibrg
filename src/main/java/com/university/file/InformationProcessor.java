package com.university.file;


import com.university.evaluation.Evaluation;
import com.university.person.Student;
import com.university.university.University;

import java.util.*;

public class InformationProcessor {

    public ArrayList<String> makeListOfEvaluationToWrite(ArrayList<Evaluation> evaluationList) {
        ArrayList<String> studentEvaluationDataList = new ArrayList<>();
        for (Evaluation evaluation : evaluationList) {
            String stringToAdd = "";
            stringToAdd += evaluation.getSubject() + "," + evaluation.getName() + "," + evaluation.getStudent() + "," + evaluation.getGrade().toString() ;
            studentEvaluationDataList.add(stringToAdd);
        }
        Collections.sort(studentEvaluationDataList, (s1, s2) -> {
            // Compare lexicographically
            int resultado = s1.compareTo(s2);

            // If equal up to the length of the shorter string, longer word goes first
            if (resultado == 0) {
                return Integer.compare(s2.length(), s1.length()); // Longer first
            }

            return resultado;
        });



        return studentEvaluationDataList;
    }

    public ArrayList<ArrayList<String>> makeListOfStudentToWrite(University university){
        ArrayList<ArrayList<String>> studentStringList = new ArrayList<>();
        for (Student student : university.getStudentList()){
            ArrayList<String> listToAdd = new ArrayList<>();
            listToAdd.add(student.getName());
            int courseCount = student.getCourseList().size();
            listToAdd.add(Integer.toString(courseCount));
            studentStringList.add(listToAdd);
        }
         Collections.sort(studentStringList, new Comparator<ArrayList<String>>() {
            @Override
            public int compare(ArrayList<String> o1, ArrayList<String> o2) {        //si no esta bien el orden, mira aca.
                return o1.getFirst().compareTo(o2.getFirst());
            }
        });
        return studentStringList;
    }

    public ArrayList<String> makeListOfExaminedStudentsToWrite(ArrayList<ArrayList<String>> examinedStudentList){
        ArrayList<String> listToWrite = new ArrayList<>();
        for (ArrayList<String> subList : examinedStudentList){
            String stringToAdd = subList.getFirst()+ "," + subList.get(1) + "," + subList.getLast();
            listToWrite.add(stringToAdd);
        }
         Collections.sort(listToWrite);
    return listToWrite;
    }
}
