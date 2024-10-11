package com.university.testPerson;

import com.university.person.Person;
import com.university.university.University;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testPerson {
    @Test
    public void testPerson(){
        Person person1 = new Person("Armando Paredes", "armando@paredes");
        assertEquals("Armando Paredes", person1.getName());
        assertEquals("armando@paredes", person1.getMail());

        University myUniversity = new University("Austral");
    }
}
