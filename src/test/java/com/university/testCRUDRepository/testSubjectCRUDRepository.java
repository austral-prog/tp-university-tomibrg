package com.university.testCRUDRepository;

import com.university.cli.repository.SubjectCRUDRepository;
import com.university.person.Student;
import com.university.subject.Subject;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class testSubjectCRUDRepository {

    @Test
    public void testSubjectRepository(){
        SubjectCRUDRepository entityRepository = new SubjectCRUDRepository();

        entityRepository.create(new Subject("Math"));

        Subject entityComparator = new Subject("Math");

        ArrayList<Subject> expectedList = new ArrayList<>();
        expectedList.add(entityComparator);
        expectedList.getFirst().setId(1);

        assertTrue(expectedList.equals(entityRepository.getSubjectRepository()));

        entityRepository.create(new Subject("Math"));
        assertTrue(expectedList.equals(entityRepository.getSubjectRepository()));

        assertTrue(entityComparator.equals(entityRepository.read(1)));
        assertNull(entityRepository.read(2));

        Subject entityUpload = new Subject("Literature");

        expectedList.removeFirst();
        expectedList.add(entityUpload);

        entityRepository.update(1, entityUpload);
        assertTrue(expectedList.equals(entityRepository.getSubjectRepository()));
    }

}
