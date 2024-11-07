package com.university.testCRUDRepository;

import com.university.cli.repository.EvaluationCRUDRepository;
import com.university.cli.repository.SubjectCRUDRepository;
import com.university.evaluation.Evaluation;
import com.university.evaluation.OralExam;
import com.university.evaluation.WrittenExam;
import com.university.person.Student;
import com.university.subject.Subject;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class testEvaluationCRUDRepository {

    @Test
    public void testEvaluationRepository(){

        EvaluationCRUDRepository entityRepository = new EvaluationCRUDRepository();

        entityRepository.create(new WrittenExam("Primer Parcial", "Math", "Written Exam", "Tomas"));

        Evaluation entityComparator = new WrittenExam("Primer Parcial", "Math", "Written Exam", "Tomas");

        ArrayList<Evaluation> expectedList = new ArrayList<>();
        expectedList.add(entityComparator);
        expectedList.getFirst().setId(1);

        assertTrue(expectedList.equals(entityRepository.getEvaluationRepository()));

        entityRepository.create(new WrittenExam("Primer Parcial", "Math", "Written Exam", "Tomas"));
        assertTrue(expectedList.equals(entityRepository.getEvaluationRepository()));

        assertTrue(entityComparator.equals(entityRepository.read(1)));
        assertNull(entityRepository.read(2));

        Evaluation entityUpload = new OralExam("Oral exam", "literature", "oral exam", "alberto");

        expectedList.removeFirst();
        expectedList.add(entityUpload);

        entityRepository.update(1, entityUpload);
        assertTrue(expectedList.equals(entityRepository.getEvaluationRepository()));
    }
}
