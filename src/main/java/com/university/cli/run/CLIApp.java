package com.university.cli.run;

import com.university.CLI;
import com.university.CRUDRepository;
import com.university.Entity;
import com.university.cli.repository.EvaluationCRUDRepository;
import com.university.cli.repository.StudentCRUDRepository;
import com.university.cli.repository.SubjectCRUDRepository;
import com.university.evaluation.Evaluation;
import com.university.person.Student;
import com.university.subject.Subject;

import java.util.List;

public class CLIApp{
    public static void main(String[] args) {
        CLI cli = new CLIHelper();
        CRUDRepository<Student> studentRepository = new StudentCRUDRepository();
        CRUDRepository<Subject> subjectRepository = new SubjectCRUDRepository();
        CRUDRepository<Evaluation> evaluationRepository = new EvaluationCRUDRepository();
        List<CRUDRepository<?>> repositoryList =  List.of(studentRepository, subjectRepository, evaluationRepository);
        CRUDRepository<Entity>[] repositories = repositoryList.toArray(new CRUDRepository[0]);
        cli.runCLI(repositories);
    }


}


