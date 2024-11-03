package com.university.evaluation.examinator;

import com.university.evaluation.Evaluation;
import com.university.person.Student;
import com.university.subject.Subject;
import com.university.university.University;

import java.util.ArrayList;

public class Examinator {

    public ArrayList<ArrayList<String>> examine(University university){
        ArrayList<Student> studentList = new ArrayList<>(university.getStudentList());
         ArrayList<ArrayList<String>> examinedStudentList = new ArrayList<ArrayList<String>>();

        for (Student student : studentList){

            for (Subject subject : student.getEvaluationMap().keySet()){

                boolean containsSubject = false;
                Integer indexOfExam = null;

                for (ArrayList<String> exam : examinedStudentList){
                    if (exam.contains(subject.getName()) && exam.contains(student.getName())){
                        containsSubject = true;
                        indexOfExam = examinedStudentList.indexOf(exam);
                    }
                }

                if (subject.getCriteria().containsKey("AVERAGE_ABOVE_VALUE")){

                    determineApproval(containsSubject, student, subject,examinedStudentList,indexOfExam,averageAboveValueExaminator(student,subject));

                } else if (subject.getCriteria().containsKey("MIN_ABOVE_VALUE")){
                    determineApproval(containsSubject, student, subject, examinedStudentList, indexOfExam, minAboveValueExaminator(student, subject));

                } else if(subject.getCriteria().containsKey("MAX_ABOVE_VALUE")){

                    determineApproval(containsSubject, student, subject, examinedStudentList, indexOfExam, maxAboveValueExaminator(student,subject));
                }else {
                    determineApproval(containsSubject,student,subject,examinedStudentList,indexOfExam,"f");
                }
            }
        }
        return examinedStudentList;
    }

    private String averageAboveValueExaminator(Student student, Subject subject){
        String isApproved = null;
        ArrayList<Evaluation> tpEvaluation = new ArrayList<>();
        for (Evaluation evaluation : student.getEvaluationMap().get(subject)){
            if (evaluation.getName().contains("TP")){
                tpEvaluation.add(evaluation);
            }
        }
        if (subject.getCriteria().get("AVERAGE_ABOVE_VALUE").size() == tpEvaluation.size()) {
            Double average = 0.0;

            for (Evaluation tp : tpEvaluation) {
                average += tp.getGrade();
            }
            average /= tpEvaluation.size();

            if (average >= 6.0) {
                isApproved = "A";

            } else {
                isApproved = "F";
            }

        } else{
            isApproved = "F";
        }

        return isApproved;
    }

    private void determineApproval(boolean containsSubject, Student student, Subject subject,ArrayList<ArrayList<String>> examinedStudentList, Integer indexOfExam, String ExamExaminator ){


            if (!containsSubject){
                if (ExamExaminator.equalsIgnoreCase("F")) {

                    ArrayList<String> listToAdd = new ArrayList<>();
                    listToAdd.add(subject.getName());
                    listToAdd.add(student.getName());
                    listToAdd.add("F");
                    examinedStudentList.add(listToAdd);
                }else {

                    ArrayList<String> listToAdd = new ArrayList<>();
                    listToAdd.add(subject.getName());
                    listToAdd.add(student.getName());
                    listToAdd.add("A");
                    examinedStudentList.add(listToAdd);
                }
            } else{
                if (ExamExaminator.equalsIgnoreCase("F")) {
                    examinedStudentList.get(indexOfExam).set(1, "F");
                }
            }
    }

    private String minAboveValueExaminator(Student student, Subject subject){
        String isApproved = null;
        ArrayList<Evaluation> parcialEvaluation = new ArrayList<>();
        for (Evaluation evaluation : student.getEvaluationMap().get(subject)){
            if (evaluation.getName().contains("Parcial")){
                parcialEvaluation.add(evaluation);
            }
        }
        if (subject.getCriteria().get("MIN_ABOVE_VALUE").size() == parcialEvaluation.size()) {

            if (parcialEvaluation.getFirst().getGrade() >= 4.0 && parcialEvaluation.getLast().getGrade() >= 4.0) {
                isApproved = "A";

            } else {
                isApproved = "F";
            }

        } else{
            isApproved = "F";
        }

        return isApproved;
    }

    private String maxAboveValueExaminator(Student student, Subject subject){
        String isApproved = null;
        ArrayList<Evaluation> finalEvaluation = new ArrayList<>();
        for (Evaluation evaluation : student.getEvaluationMap().get(subject)){
            if (evaluation.getName().contains("Final")){
                finalEvaluation.add(evaluation);
            }
        }
        if (subject.getCriteria().get("MAX_ABOVE_VALUE").size() == finalEvaluation.size()) {

            if (finalEvaluation.getFirst().getName().equalsIgnoreCase("TP Final")) {

                if (finalEvaluation.getFirst().getGrade() >= 6.0) {
                    isApproved = "A";

                } else {
                    isApproved = "F";
                }
            } else {
                if (finalEvaluation.getFirst().getGrade() >= 4.0) {
                    isApproved = "A";

                } else {
                    isApproved = "F";
                }
            }
        } else{
            isApproved = "F";
        }

        return isApproved;
    }

}
