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
        ArrayList<String> compareList = new ArrayList<>();
        compareList.add("Math");
        assertEquals(compareList, student1.getCourseList());
    }




}
