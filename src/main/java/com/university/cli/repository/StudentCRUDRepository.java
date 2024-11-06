package com.university.cli.repository;

import com.university.CRUDRepository;
import com.university.person.Student;

import java.util.ArrayList;

public class StudentCRUDRepository implements CRUDRepository<Student> {
   ArrayList<Student> studentRepository = new ArrayList<>();

    @Override
    public void create(Student entity) {
        if (!studentRepository.contains(entity)){

            studentRepository.add(entity);

            if (studentRepository.size() - 1 == 0){
                entity.setId(1);
            }else {
                int lastAddedIndex = studentRepository.indexOf(entity);
                entity.setId(studentRepository.get(lastAddedIndex - 1).getId() + 1);
            }

            System.out.println("\nYou have created:\n");
            System.out.println("Student: " + entity.getName());
            System.out.println("Id: " + entity.getId());
        }else {
            System.out.println("\nStudent already exists");
            try{
                Thread.sleep(500);
            } catch (Exception e){
                System.out.println("Something went wrong");

            }
        }
    }

    @Override
    public Student read(int id) {
        Student studentToReturn = null;

        for (Student student : studentRepository){
            if (student.getId() == id){
                studentToReturn = student;
            }
        }
        return  studentToReturn;
    }

    @Override
    public void update(int id, Student entity) {
        Student studentToUpdate = this.read(id);
        if (studentToUpdate !=  null){
            int indexOfStudentToUpdate = studentRepository.indexOf(studentToUpdate);
            entity.setId(studentToUpdate.getId());
            studentRepository.set(indexOfStudentToUpdate, entity);

        }else {
            System.out.println("Invalid ID");
        }
    }

    @Override
    public void delete(int id) {
        Student studentToDelete = this.read(id);
         if (studentToDelete != null){
             studentRepository.remove(studentToDelete);
             System.out.println("You deleted:");
             System.out.println("Student: " + studentToDelete.getName());
         }else {
             System.out.println("Invalid ID");
         }
    }

    @Override
    public String getIdentifier() {
        return "Student";
    }

    @Override
    public Class<Student> getEntityClass() {
        return Student.class;
    }
}
