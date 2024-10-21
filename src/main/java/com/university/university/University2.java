package com.university.university;

import com.university.evaluation.Evaluation;
import com.university.evaluation.EvaluationFactory;
import com.university.file.InformationProcessor;
import com.university.person.Student;
import com.university.subject.Subject;

import java.util.ArrayList;
import java.util.HashMap;

public class University2 extends University{
    HashMap<String, Student> studentMap = new HashMap<String, Student>();
    HashMap<String, Subject> subjectMap = new HashMap<String, Subject>();
    ArrayList<Evaluation> evaluationList;

    public University2(String name) {
        super(name);
    }

    @Override
    public HashMap<String, Student> getStudentMap(){
        return studentMap;
    }

    public ArrayList<Evaluation> getEvaluationList(){
        return evaluationList;
    }

    @Override
    public void makeAllHashMapsAndList(ArrayList<String[]> dataList) {
        EvaluationFactory myEvaluationFactory = new EvaluationFactory();
        evaluationList = myEvaluationFactory.createEvaluationList(dataList);

    }





}

