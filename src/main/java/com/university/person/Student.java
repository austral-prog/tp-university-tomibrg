package com.university.person;



import com.university.evaluation.Evaluation;
import com.university.factory.Factorable;
import com.university.subject.Subject;
import com.university.university.University;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Student extends Person implements Factorable {

    private ArrayList<String> courseList = new ArrayList<>();
    private HashMap<Subject, ArrayList<Evaluation>> evaluationMap = new HashMap<>();


    public Student(String name) {
        super(name);

    }

    public ArrayList<String> getCourseList(){
        return courseList;
    }

    public void addCourse(String course){
        if (!courseList.contains(course)) {
            courseList.add(course);
        }
    }



    public ArrayList<String> getSortedStudents(){
        ArrayList<String> sortedStudents = new ArrayList<String>();
        Collections.sort(sortedStudents);
        return sortedStudents;
    }


    public HashMap<Subject, ArrayList<Evaluation>> getEvaluationMap() {
        return evaluationMap;
    }

    public void addEvaluation(Subject subject, Evaluation evaluation){
        if (!evaluationMap.containsKey(subject)){
            evaluationMap.put(subject, new ArrayList<Evaluation>());
            evaluationMap.get(subject).add(evaluation);
        }else{
            evaluationMap.get(subject).add(evaluation);
        }
    }



    @Override
    public boolean equals(Object other) {
        boolean returnStatement = false;
        Student student = (Student) other;

        if (this.getName().equals(((Student) other).getName())) {
            returnStatement = true;
        }
        return returnStatement;
    }

}
