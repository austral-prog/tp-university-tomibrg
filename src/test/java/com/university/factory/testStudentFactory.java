package com.university.factory;

import com.university.file.InformationExtractor;
import com.university.person.Student;
import com.university.person.StudentFactory;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class testStudentFactory {

    @Test
    public void testMakeSelfList(){
        InformationExtractor myInformationExtractor = new InformationExtractor();
        ArrayList<String[]> dataList = myInformationExtractor.extractFileData("src/main/resources/test.csv");
        StudentFactory myStudentFactory = new StudentFactory();
        ArrayList<Student> toBeTestedStudentList = myStudentFactory.createSelfList(dataList);
        Student student1 = new Student("Armando Paredes");
        student1.addCourse("Math");
        Student student2 = new Student("Armando Esteban Quito");
        student2.addCourse("Math");
        Student student3 = new Student("Federico Ibarra");
        student3.addCourse("Accounting");
        ArrayList<Student> expectedStudentList = new ArrayList<>();
        expectedStudentList.add(student2);
        expectedStudentList.add(student3);
        expectedStudentList.add(student1);
        assertTrue(expectedStudentList.getFirst().equals(toBeTestedStudentList.getFirst()));
        assertTrue(expectedStudentList.get(1).equals(toBeTestedStudentList.get(1)));
        assertTrue(expectedStudentList.getLast().equals(toBeTestedStudentList.getLast()));
    }
}
