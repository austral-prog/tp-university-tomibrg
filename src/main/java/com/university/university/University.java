package com.university.university;


import com.university.evaluation.Evaluation;
import com.university.evaluation.EvaluationFactory;
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

    public ArrayList<Subject> getSubjectList() {
        return subjectList;
    }


    public void makeSubjectList(ArrayList<String[]> dataList){
        SubjectFactory mySubjectFactory = new SubjectFactory();
        subjectList = mySubjectFactory.createSelfList(dataList);
    }

    public void makeStudentList(ArrayList<String[]> dataList){
        StudentFactory myStudentFactory = new StudentFactory();
        studentList = myStudentFactory.createSelfList(dataList);
        for (Student student : studentList){
            makeEvaluationMapForStudents(this, student);
        }
    }

    public void makeEvaluationMapForStudents(University university, Student student){
        for(String course : student.getCourseList()){
            for (Subject subject : university.getSubjectList()){
                if(subject.getName().equalsIgnoreCase(course)){
                    student.getEvaluationMap().put(subject, new ArrayList<Evaluation>());
                }
            }
        }
    }

    public ArrayList<Evaluation> getEvaluationList(){
        return evaluationList;
    }

    public void makeEvaluationList(ArrayList<String[]> dataList){
        EvaluationFactory myEvaluationFactory = new EvaluationFactory();
        evaluationList = myEvaluationFactory.createSelfList(dataList);
    }
}
