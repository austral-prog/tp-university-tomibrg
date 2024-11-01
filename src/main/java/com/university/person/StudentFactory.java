package com.university.person;

import com.university.factory.Factorable;
import com.university.factory.Factory;

import java.util.ArrayList;
import java.util.HashMap;

public class StudentFactory implements Factory<Student> {

    @Override
    public ArrayList<Student> createSelfList(ArrayList<String[]> dataList) {
        HashMap<String, Student> studentMap = new HashMap<>();
        for (String[] lineList : dataList){
            String course = lineList[1];
            String studentName = lineList[2];

            if(!studentMap.containsKey(studentName)){
                studentMap.put(studentName, new Student(studentName));
                studentMap.get(studentName).addCourse(course);
            }
            else{
                studentMap.get(studentName).addCourse(course);
            }
        }
        return mapToList(studentMap);
    }

    private ArrayList<Student> mapToList(HashMap<String, Student> studentMap){
        ArrayList<Student> studentList = new ArrayList<>();
        for (Student student : studentMap.values()){
            studentList.add(student);
        }
        return studentList;
    }

}
