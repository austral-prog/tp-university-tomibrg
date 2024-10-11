package com.university.testUniversity;

import com.university.file.InformationExtractor;
import com.university.person.Person;
import com.university.person.Student;
import com.university.person.Teacher;
import com.university.subject.Subject;
import com.university.university.University;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class testUniversity {

    @Test
    public void testMakeAllMaps(){
        University myUniversity = new University("Austral");
        Student myStudent = new Student("Armando Paredes", "armando@paredes");
        Teacher myTeacher = new Teacher("Prof.alberto", "ajsdna@jsnd");
        Subject mySubject = new Subject("Math");

        InformationExtractor myInformationExtractor = new InformationExtractor();
        ArrayList<String[]> dataList = myInformationExtractor.extractFileData("src/main/resources/test.csv");
        myUniversity.makeAllHashMapsAndList(dataList);

        HashMap<String, Student> myStudentMap = new HashMap<String, Student>();
        HashMap<String, Teacher> myTeacherMap = new HashMap<String, Teacher>();
        HashMap<String, Subject> mySubjectMap = new HashMap<String, Subject>();

        ArrayList<String> myClassroomList = new ArrayList<String>();
        myClassroomList.add("123");

        myStudentMap.put("Armando Paredes", myStudent);
        myTeacherMap.put("Prof.alberto", myTeacher);
        mySubjectMap.put("Math", mySubject);
        assertEquals(myStudentMap, myUniversity.getStudentMap());
        assertEquals(myTeacherMap, myUniversity.getTeacherMap());
        assertEquals(mySubjectMap, myUniversity.getSubjectMap());
        assertEquals(myClassroomList, myUniversity.getClassroomList());

    }

    @Test
    public void testStudentLists(){
        Student myStudent = new Student("Armando Paredes", "armando@paredes");
        assertEquals("Armando Paredes", myStudent.getName());
        assertEquals("armando@paredes", myStudent.getMail());

        University myUniversity = new University("Austral");
        Teacher myTeacher = new Teacher("Prof.alberto", null);
        ArrayList<String> myClassroomList = new ArrayList<String>();
        myClassroomList.add("123");
        Subject mySubject = new Subject("Math");

        myStudent.addCourse("Math");
        myTeacher.addSubject("Math");
        myTeacher.addClassroom("123");
        myTeacher.addStudent("Armando Paredes");
        mySubject.addStudent("Armando Paredes");

        InformationExtractor myInformationExtractor = new InformationExtractor();
        ArrayList<String[]> dataList = myInformationExtractor.extractFileData("src/main/resources/test.csv");
        myUniversity.makeAllHashMapsAndList(dataList);

        assertEquals(myStudent.getCourseList(), myUniversity.getStudentMap().get("Armando Paredes").getCourseList());
        assertEquals(myTeacher.getSubjectList(), myUniversity.getTeacherMap().get("Prof.alberto").getSubjectList());
        assertEquals(myTeacher.getStudentList(), myUniversity.getTeacherMap().get("Prof.alberto").getStudentList());
        assertEquals(myTeacher.getClassroomList(), myUniversity.getTeacherMap().get("Prof.alberto").getClassroomList());
    }
}
