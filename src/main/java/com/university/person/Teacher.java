package com.university.person;

import java.util.ArrayList;

public class Teacher extends Person{
    ArrayList<String> classroomList = new ArrayList<String>();
    ArrayList<String> studentList = new ArrayList<String>();
    ArrayList<String> subjectList = new ArrayList<String>();

    public Teacher(String name, String mail) {
        super(name, mail);
    }

    public ArrayList<String> getClassroomList() {
        return classroomList;
    }

    public ArrayList<String> getStudentList() {
        return studentList;
    }

    public ArrayList<String> getSubjectList() {
        return subjectList;
    }

    public void addClassroom(String classroom){
        if (!classroomList.contains(classroom)) {
            classroomList.add(classroom);
        }
    }

    public void addStudent(String student){
        if (!studentList.contains(student)) {
            studentList.add(student);
        }
    }

    public void addSubject(String subject){
        if (!subjectList.contains(subject)) {
            subjectList.add(subject);
        }
    }

    @Override
    public boolean equals(Object other) {
        boolean returnStatement = false;
        Teacher teacher = (Teacher) other;

        if (this.getName().equals(((Teacher) other).getName())) {
            returnStatement = true;
        }
        return returnStatement;
    }
}
