package com.university.factory;

import com.university.file.InformationExtractor;
import com.university.person.Student;
import com.university.subject.Subject;
import com.university.subject.SubjectFactory;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class testSubjectFactory {
    @Test
    public void testCreateSelfLis(){
        InformationExtractor myInformationExtractor = new InformationExtractor();
        ArrayList<String[]> dataList = myInformationExtractor.extractFileData("src/main/resources/test.csv");
        SubjectFactory mySubjectFactory = new SubjectFactory();
        ArrayList<Subject> toBeTestedSubjectList = mySubjectFactory.createSelfList(dataList);

        Subject subject1 = new Subject("Math");
        subject1.addStudent("Armando Paredes");
        subject1.addStudent("Armando Esteban Quito");
        subject1.addClassroom("123");
        subject1.addClassroom("456");

        Subject subject2 = new Subject("Accounting");
        subject2.addClassroom("123");
        subject2.addStudent("Federico Ibarra");

        ArrayList<Subject> expectedSubjectList = new ArrayList<>();
        expectedSubjectList.add(subject2);
        expectedSubjectList.add(subject1);

        assertTrue(expectedSubjectList.getFirst().equals(toBeTestedSubjectList.getFirst()));
        assertTrue(expectedSubjectList.getLast().equals(toBeTestedSubjectList.getLast()));

        ArrayList<String> toBeTestedClassroomList1 = toBeTestedSubjectList.getFirst().getClassroomList();
        ArrayList<String> toBeTestedClassroomList2 = toBeTestedSubjectList.getLast().getClassroomList();

        ArrayList<String> expectedClassroomList1 = expectedSubjectList.getFirst().getClassroomList();
        ArrayList<String> expectedClassroomList2 = expectedSubjectList.getLast().getClassroomList();

        assertEquals(expectedClassroomList1, toBeTestedClassroomList1);
        assertEquals(expectedClassroomList2, toBeTestedClassroomList2);

        ArrayList<String> toBeTestedStudentList1 = toBeTestedSubjectList.getFirst().getStudentsList();
        ArrayList<String> toBeTestedStudentList2 = toBeTestedSubjectList.getLast().getStudentsList();

        ArrayList<String> expectedStudentList1 = expectedSubjectList.getFirst().getStudentsList();
        ArrayList<String> expectedStudentList2 = expectedSubjectList.getLast().getStudentsList();

        assertEquals(expectedStudentList1, toBeTestedStudentList1);
        assertEquals(expectedStudentList2, toBeTestedStudentList2);
    }
}
