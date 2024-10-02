package com.university.testPerson;

import com.university.person.Person;
import com.university.person.Student;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testStudent {

    @Test
    public void testStudent(){
        Student student1 = new Student("Tomas", "tomas@org.com");
        assertEquals("Tomas", student1.getName());
        assertEquals("tomas@org.com", student1.getMail());

        Student student2 = new Student("Matias", "matias@org.com");
        assertEquals("Matias", student2.getName());
        assertEquals("matias@org.com", student2.getMail());

        student1.addCourse("Math");
        student1.addCourse("Biology");
        ArrayList<String> compareList = new ArrayList<String>();
        compareList.add("Math");
        compareList.add("Biology");
        Collections.sort(compareList);
        assertEquals(compareList, student1.getCourseList());

        ArrayList<Student> studentList = new ArrayList<Student>();
        studentList.add(student1);
        studentList.add(student2);
        assertEquals(studentList, student2.getStudentsList());
    }

    @Test
    public void testSortedStudents(){
        Student student1 = new Student("b", "kjasbdk");
        Student student2 = new Student("c", "kjadnka");
        Student student3 = new Student("a", "akjndf");
        ArrayList<String> expectedList = new ArrayList<String>();
        expectedList.add("a");
        expectedList.add("b");
        expectedList.add("c");
        assertEquals(expectedList, student3.getSortedStudents());
    }
}
