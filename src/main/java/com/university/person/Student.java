package com.university.person;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Student extends Person {
    private HashSet<String> courseList = new HashSet<String>();
    private static ArrayList<Student> studentsList= new ArrayList<Student>();

    public Student(String name) {
        super(name);
        studentsList.add(this);
    }

    public HashSet<String> getCourseList(){
        return courseList;
    }

    public void addCourse(String course){
        courseList.add(course);
    }

    public ArrayList<Student> getStudentsList() {
        return studentsList;
    }

    public ArrayList<String> getSortedStudents(){
        ArrayList<String> sortedStudents = new ArrayList<String>();
        for (int i = 0; i < studentsList.size(); i++) {
            Student currentStudent = studentsList.get(i);
            sortedStudents.add(currentStudent.getName());
        }
        Collections.sort(sortedStudents);
        return sortedStudents;
    }

    public ArrayList<Student> getSortedStudentsTypedList(){
        ArrayList<String> sortedStudentsName = this.getSortedStudents();
        ArrayList<Student> sortedStudents = new ArrayList<Student>();
        for (int i = 0; i < sortedStudentsName.size(); i++) {
            String currentStudentName = sortedStudentsName.get(i);
            for (Student student : studentsList){
                if (student.getName().equals(currentStudentName)){
                    sortedStudents.add(student);
                }
            }
        }
        return sortedStudents;
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
