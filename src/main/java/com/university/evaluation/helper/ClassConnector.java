package com.university.evaluation.helper;

import com.university.evaluation.Evaluation;
import com.university.person.Student;
import com.university.subject.Subject;
import com.university.university.University;

import java.util.ArrayList;
import java.util.HashMap;

public class ClassConnector {

    public void connectClass(University university){
        //El resultado es tener un hashmap en los estudiantes con k: subject y v:AList<Evaluation>
        for (Student student : university.getStudentList()){
            for (Evaluation evaluation: university.getEvaluationList()){
                if (student.getName().equalsIgnoreCase(evaluation.getStudent())){
                    Subject evaluationSubject = null;
                    for (Subject subject : university.getSubjectList()){
                        if (evaluation.getSubject().equalsIgnoreCase(subject.getName())){
                            evaluationSubject = subject;
                        }
                    }
                    student.addEvaluation(evaluationSubject,evaluation);

                }
            }
        }
    }
}
