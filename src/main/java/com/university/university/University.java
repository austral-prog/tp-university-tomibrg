package com.university.university;


import com.university.evaluation.Evaluation;
import com.university.person.Student;
import com.university.person.StudentFactory;
import com.university.subject.Subject;
import com.university.subject.SubjectFactory;

import java.util.ArrayList;

public class University {

    private ArrayList<Subject> subjectList = new ArrayList<>();
    private ArrayList<Student> studentList = new ArrayList<>();
    private ArrayList<Evaluation> evaluationList;
    private String name;

    public University(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public ArrayList<Student> getStudentList() {
        return studentList;
    }

    public ArrayList<Subject> getSubjectMap() {
        return subjectList;
    }


    public void makeAllHashMapsAndList(ArrayList<String[]> dataList){
        privateMakeSubjectList(dataList);
        privateMakeStudentList(dataList);
    }

    private void privateMakeSubjectList(ArrayList<String[]> dataList){
        SubjectFactory mySubjectFactory = new SubjectFactory();
        subjectList = mySubjectFactory.createSelfList(dataList);
    }

    private void privateMakeStudentList(ArrayList<String[]> dataList){
        StudentFactory myStudentFactory = new StudentFactory();
        studentList = myStudentFactory.createSelfList(dataList);
    }

    public ArrayList<Evaluation> getEvaluationList(){
        return evaluationList;
    }
}
