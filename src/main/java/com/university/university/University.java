package com.university.university;

import com.university.person.Student;
import com.university.person.Teacher;
import com.university.subject.Subject;

import java.util.ArrayList;
import java.util.HashMap;

public class University {

    private ArrayList<String> classRoomList = new ArrayList<String>();
    private HashMap<String, Subject> subjectMap = new HashMap<String,Subject>();
    private HashMap<String, Student> studentMap = new HashMap<String, Student>();
    private HashMap<String, Teacher> teacherMap = new HashMap<String, Teacher>();
    private String name;

    public University(String name){
        this.name = name;
    }



    public String getName(){
        return name;
    }

    public ArrayList<String> getClassroomList() {
        return classRoomList;
    }

    public HashMap<String, Student> getStudentMap() {
        return studentMap;
    }

    public HashMap<String, Subject> getSubjectMap() {
        return subjectMap;
    }

    public HashMap<String, Teacher> getTeacherMap() {
        return teacherMap;
    }

    public void makeAllHashMapsAndList(ArrayList<String[]> dataList){
        privateMakeClassroomList(dataList);
        privateMakeStudentHashMap(dataList);
        privateMakeSubjectHashMap(dataList);
        privateMakeTeacherHashMap(dataList);
    }

    public void privateMakeClassroomList(ArrayList<String[]> dataList){
        for (String[] studentData : dataList){
            if (!classRoomList.contains(studentData[0])){
                classRoomList.add(studentData[0]);
            }
        }
    }

    public void privateMakeStudentHashMap(ArrayList<String[]> dataList){

        for (String[] studentData : dataList){
            if (!studentMap.containsKey(studentData[2])){
                studentMap.put(studentData[2], new Student(studentData[2]));
                studentMap.get(studentData[2]).addCourse(studentData[1]);
            }
            else{
                studentMap.get(studentData[2]).addCourse(studentData[1]);
            }
        }
    }

    public void privateMakeSubjectHashMap(ArrayList<String[]> dataList){

        for (String[] studentData : dataList){
            if (!subjectMap.containsKey(studentData[1])){
                subjectMap.put(studentData[1], new Subject(studentData[1]));
                subjectMap.get(studentData[1]).addStudent(studentData[0]);
            }
            else{
                subjectMap.get(studentData[1]).addStudent(studentData[0]);
            }
        }
    }

    public void privateMakeTeacherHashMap(ArrayList<String[]> dataList){

        for (String[] studentData : dataList){
            if (!teacherMap.containsKey(studentData[4])){
                teacherMap.put(studentData[4], new Teacher(studentData[4]));
                teacherMap.get(studentData[4]).addStudent(studentData[2]);
                teacherMap.get(studentData[4]).addClassroom(studentData[0]);
                teacherMap.get(studentData[4]).addSubject(studentData[1]);
            }
            else{
                teacherMap.get(studentData[4]).addStudent(studentData[2]);
                teacherMap.get(studentData[4]).addClassroom(studentData[0]);
                teacherMap.get(studentData[4]).addSubject(studentData[1]);
            }
        }
    }
}
