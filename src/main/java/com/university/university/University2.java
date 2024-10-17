package com.university.university;

import com.university.evaluation.Evaluation;
import com.university.person.Student;
import com.university.subject.Subject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

public class University2 extends University{
    HashMap<String, Student> studentMap = new HashMap<String, Student>();
    HashMap<String, Subject> subjectMap = new HashMap<String, Subject>();
    HashMap<String, HashMap<String, HashMap<String, Evaluation>>> evaluationMap = new HashMap<>();

    public University2(String name) {
        super(name);
    }

    @Override
    public HashMap<String, Student> getStudentMap(){
        return studentMap;
    }

    public HashMap<String, HashMap<String, HashMap<String, Evaluation>>> getEvaluationMap(){
        return evaluationMap;
    }

    @Override
    public void makeAllHashMapsAndList(ArrayList<String[]> dataList) {

        privateMakeStudentHashMap(dataList);
        privateMakeSubjectHashMap(dataList);
        privateMakeEvaluationMap(dataList);
    }

    @Override
    public void privateMakeStudentHashMap(ArrayList<String[]> dataList){
        for (String[] studentData : dataList){
            if (!studentMap.containsKey(studentData[0])){
                studentMap.put(studentData[0], new Student(studentData[0]));
                studentMap.get(studentData[0]).addCourse(studentData[1]);
            }
            else{
                studentMap.get(studentData[0]).addCourse(studentData[1]);
            }
        }
    }

    private void privateMakeEvaluationMap(ArrayList<String[]> dataList){
        HashMap<String, Evaluation> studentEvaluationMap= new HashMap<>();
        for (String[] studentData : dataList){
            String studentName = studentData[0];
            String subject = studentData[1];
            String type = studentData[2];
            String evaluationName = studentData[3];
            String exercise = studentData[4];
            String grade = studentData[5];

            if (!evaluationMap.containsKey(subject)){
                evaluationMap.put(subject, new HashMap<String,  HashMap<String, Evaluation>>());
                evaluationMap.get(subject).put(studentName, new HashMap<String, Evaluation>());
                evaluationMap.get(subject).get(studentName).put(evaluationName, new Evaluation(evaluationName, subject, type, new Student(studentName)));
                evaluationMap.get(subject).get(studentName).get(evaluationName).addExerciseMark(evaluationName, Integer.parseInt(grade));
            }
            else{
                if (!evaluationMap.get(subject).containsKey(studentName)){
                    evaluationMap.get(subject).put(studentName, new HashMap<String, Evaluation>());
                    evaluationMap.get(subject).get(studentName).put(evaluationName, new Evaluation(evaluationName, subject, type, new Student(studentName)));
                    evaluationMap.get(subject).get(studentName).get(evaluationName).addExerciseMark(evaluationName,Integer.parseInt(grade));
                }
                else{
                    if(!evaluationMap.get(subject).get(studentName).containsKey(evaluationName)) {
                        evaluationMap.get(subject).get(studentName).put(evaluationName, new Evaluation(evaluationName, subject, type, new Student(studentName)));
                        evaluationMap.get(subject).get(studentName).get(evaluationName).addExerciseMark(evaluationName, Integer.parseInt(grade));
                    }
                    else{
                        evaluationMap.get(subject).get(studentName).get(evaluationName).addExerciseMark(evaluationName, Integer.parseInt(grade));
                    }
                }
            }
        }
    }
}

