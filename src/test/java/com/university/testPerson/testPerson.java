package com.university.testPerson;

import com.university.person.Person;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testPerson {
    @Test
    public void testPerson(){
        Person person1 = new Person("Tomas", "tomas@org.com");
        assertEquals("Tomas", person1.getName());
        assertEquals("tomas@org.com", person1.getMail());

        Person person2 = new Person("Matias", "matias@org.com");
        assertEquals("Matias", person2.getName());
        assertEquals("matias@org.com", person2.getMail());
    }
}
