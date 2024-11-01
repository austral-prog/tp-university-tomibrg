package com.university.subject;

import com.university.factory.Factorable;
import com.university.factory.Factory;

import java.util.ArrayList;
import java.util.HashMap;

public class SubjectFactory implements Factory<Subject> {

    @Override
    public ArrayList<Subject> createSelfList(ArrayList<String[]> dataList) {
        // crea el subject y le agrega todos sus classrooms
        HashMap<String, Subject> subjectMap = new HashMap<>();
        for (String[] lineList : dataList){
            String classRoom = lineList[0];
            String subjectName = lineList[1];
            String studentName = lineList[2];

            if (!subjectMap.containsKey(subjectName)){
                subjectMap.put(subjectName, new Subject(subjectName));
                subjectMap.get(subjectName).addClassroom(classRoom);
                subjectMap.get(subjectName).addStudent(studentName);
            }else{
                subjectMap.get(subjectName).addClassroom(classRoom);
                subjectMap.get(subjectName).addStudent(studentName);
            }
        }
        return makeMapToList(subjectMap);
    }

    private ArrayList<Subject> makeMapToList(HashMap<String, Subject> subjectMap){
        ArrayList<Subject> subjectList = new ArrayList<>();
        for(Subject subject : subjectMap.values()){
            subjectList.add(subject);
        }
        return subjectList;
    }
}
