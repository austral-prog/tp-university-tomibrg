package com.university.cli.repository;

import com.university.CRUDRepository;
import com.university.evaluation.Evaluation;
import com.university.person.Student;
import com.university.subject.Subject;

import java.util.ArrayList;

public class EvaluationCRUDRepository implements CRUDRepository<Evaluation> {
    private ArrayList<Evaluation> evaluationRepository = new ArrayList<>();

    @Override
    public void create(Evaluation entity) {
        if (!evaluationRepository.contains(entity)){

            evaluationRepository.add(entity);

            if (evaluationRepository.size() - 1 == 0){
                entity.setId(1);
            }else {
                int lastAddedIndex = evaluationRepository.indexOf(entity);
                entity.setId(evaluationRepository.get(lastAddedIndex - 1).getId() + 1);
            }

            System.out.println("\nYou have created:\n");
            System.out.println("Evaluation: " + entity.getName());
            System.out.println("Id: " + entity.getId());
            System.out.println("Type: " + entity.getType());
            System.out.println("Subject: " + entity.getSubject());

        }else {
            System.out.println("\nEvaluation already exists");
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                System.out.println("Something went wrong");

            }
        }
    }

    @Override
    public Evaluation read(int id) {
        Evaluation evaluationToReturn = null;

        for (Evaluation evaluation : evaluationRepository){
            if (evaluation.getId() == id){
                evaluationToReturn = evaluation;
            }
        }
        return  evaluationToReturn;
    }

    @Override
    public void update(int id, Evaluation entity) {
        Evaluation evaluationToUpdate = this.read(id);
        if (evaluationToUpdate !=  null){
            int indexOfEvaluationToUpdate = evaluationRepository.indexOf(evaluationToUpdate);
            entity.setId(evaluationToUpdate.getId());
            evaluationRepository.set(indexOfEvaluationToUpdate, entity);
        }else {
            System.out.println("Invalid ID");
        }
    }

    @Override
    public void delete(int id) {
        Evaluation evaluaitonToDelete = this.read(id);
        if (evaluaitonToDelete != null){
            evaluationRepository.remove(evaluaitonToDelete);
            System.out.println("You deleted:");
            System.out.println("Evaluation: " + evaluaitonToDelete.getName());
            System.out.println("Type: " + evaluaitonToDelete.getType());
            System.out.println("Subject: " + evaluaitonToDelete.getSubject());
            System.out.println("Student: " + evaluaitonToDelete.getStudent());
        }else {
            System.out.println("Invalid ID");
        }
    }

    @Override
    public String getIdentifier() {
        return "Evaluation";
    }

    @Override
    public Class<Evaluation> getEntityClass() {
        return Evaluation.class;
    }

    public ArrayList<Evaluation> getEvaluationRepository() {
        return evaluationRepository;
    }
}
