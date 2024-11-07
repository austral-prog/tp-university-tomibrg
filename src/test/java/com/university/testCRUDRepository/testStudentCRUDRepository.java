package com.university.testCRUDRepository;

import com.university.cli.repository.StudentCRUDRepository;
import com.university.person.Student;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class testStudentCRUDRepository {

    @Test
    public void testStudentRepository(){
        StudentCRUDRepository entityRepository = new StudentCRUDRepository();

        entityRepository.create(new Student("Tomas"));

        Student studentComparator = new Student("Tomas");

        ArrayList<Student> expectedList = new ArrayList<>();
        expectedList.add(studentComparator);
        expectedList.getFirst().setId(1);

        assertTrue(expectedList.equals(entityRepository.getStudentRepository()));

        entityRepository.create(new Student("Tomas"));
        assertTrue(expectedList.equals(entityRepository.getStudentRepository()));

        assertTrue(studentComparator.equals(entityRepository.read(1)));
        assertNull(entityRepository.read(2));

        Student entityUpload = new Student("Albert");

        expectedList.removeFirst();
        expectedList.add(entityUpload);

        entityRepository.update(1, entityUpload);
        assertTrue(expectedList.equals(entityRepository.getStudentRepository()));
    }
}
