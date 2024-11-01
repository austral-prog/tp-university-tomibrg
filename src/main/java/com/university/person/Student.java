package com.university.person;



import com.university.evaluation.Evaluation;
import com.university.factory.Factorable;

import java.util.ArrayList;
import java.util.Collections;

public class Student extends Person implements Factorable {
    private ArrayList<String> courseList = new ArrayList<>();
    private ArrayList<Evaluation> evaluationArrayList = new ArrayList<>();

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


    public ArrayList<Evaluation> getEvaluationArrayList() {
        return evaluationArrayList;
    }

    public void addEvaluation(Evaluation evaluation){
        if(!evaluationArrayList.contains(evaluation)){
            evaluationArrayList.add(evaluation);
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
