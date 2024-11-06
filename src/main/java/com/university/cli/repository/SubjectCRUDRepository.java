package com.university.cli.repository;

import com.university.CRUDRepository;
import com.university.person.Student;
import com.university.subject.Subject;

import java.util.ArrayList;

public class SubjectCRUDRepository implements CRUDRepository<Subject> {
    ArrayList<Subject> subjectRepository = new ArrayList<>();

    @Override
    public void create(Subject entity) {
        if (!subjectRepository.contains(entity)){

            subjectRepository.add(entity);

            if (subjectRepository.size() - 1 == 0){
                entity.setId(1);
            }else {
                int lastAddedIndex = subjectRepository.indexOf(entity);
                entity.setId(subjectRepository.get(lastAddedIndex - 1).getId() + 1);
            }

            System.out.println("\nYou have created:\n");
            System.out.println("Subject: " + entity.getName());
            System.out.println("Id: " + entity.getId());
        }else {
            System.out.println("\nSubject already exists");
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                System.out.println("Something went wrong");

            }
        }
    }

    @Override
    public Subject read(int id) {
        Subject subjectToReturn = null;

        for (Subject subject : subjectRepository){
            if (subject.getId() == id){
                subjectToReturn = subject;
            }
        }
        return  subjectToReturn;
    }

    @Override
    public void update(int id, Subject entity) {
        Subject subjectToUpdate = this.read(id);
        if (subjectToUpdate !=  null){
            int indexOfSubjectToUpdate = subjectRepository.indexOf(subjectToUpdate);
            entity.setId(subjectToUpdate.getId());
            subjectRepository.set(indexOfSubjectToUpdate, entity);
        }else {
            System.out.println("Invalid ID");
        }
    }

    @Override
    public void delete(int id) {
        Subject subjectToDelete = this.read(id);
        if (subjectToDelete != null){
            subjectRepository.remove(subjectToDelete);
            System.out.println("You deleted:");
            System.out.println("Subject: " + subjectToDelete.getName());
        }else {
            System.out.println("Invalid ID");
        }
    }

    @Override
    public String getIdentifier() {
        return "Subject";
    }

    @Override
    public Class<Subject> getEntityClass() {
        return Subject.class;
    }
}
