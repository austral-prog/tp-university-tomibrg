package com.university.testPerson;

import com.university.person.Person;
import com.university.person.Student;
import com.university.person.Teacher;
import com.university.university.University;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testStudent {

    @Test
    public void testStudent(){
        Student student1 = new Student("Tomas");
        assertEquals("Tomas", student1.getName());

        Student student2 = new Student("Matias");
        assertEquals("Matias", student2.getName());

        student1.addCourse("Math");
        HashSet<String> compareSet = new HashSet<String>();
        compareSet.add("Math");
        assertEquals(compareSet, student1.getCourseList());
    }

    @Test
    public void testSortedStudents(){
        Student student1 = new Student("b");
        Student student2 = new Student("c");
        Student student3 = new Student("a");
        ArrayList<String> expectedList = new ArrayList<String>();
        expectedList.add("a");
        expectedList.add("b");
        expectedList.add("c");
        assertEquals(expectedList, student3.getSortedStudents());
    }


}
