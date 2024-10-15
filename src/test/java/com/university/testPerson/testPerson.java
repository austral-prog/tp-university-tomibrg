package com.university.testPerson;

import com.university.person.Person;
import com.university.university.University;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testPerson {
    @Test
    public void testPerson(){
        Person person1 = new Person("Armando Paredes");
        assertEquals("Armando Paredes", person1.getName());

        University myUniversity = new University("Austral");
    }
}
