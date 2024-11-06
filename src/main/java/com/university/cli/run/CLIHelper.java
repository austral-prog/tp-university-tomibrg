package com.university.cli.run;

import com.university.CLI;
import com.university.CRUDRepository;
import com.university.evaluation.*;
import com.university.person.Student;
import com.university.subject.Subject;

import java.util.InputMismatchException;
import java.util.Scanner;

class CLIHelper implements CLI {
    CRUDRepository<Student> studentRepository = null;
    CRUDRepository<Subject> subjectRepository = null;
    CRUDRepository<Evaluation> evaluationRepository = null;

    @Override
    public void runCLI(CRUDRepository<?>[] crudInterfaces) {
        
        makeRepositories(crudInterfaces);


        Scanner myScanner = new Scanner(System.in);
        while (true){

            System.out.println("\nWelcome to myCLI!\n");
            System.out.println("Please choose an option:\n");
            System.out.println("1. Create");
            System.out.println("2. Read");
            System.out.println("3. Update");
            System.out.println("4. Delete");
            System.out.println("5. Exit" + "\n");

            try {
                int choice = myScanner.nextInt();

                switch (choice) {

                    case 1: {
                        //Create
                        createInCLIHelper();
                        break;
                    }
                    case 2:
                        //Read
                        readInCLIHelper();
                        break;

                    case 3:{
                        //Update
                        updateInCLIHelper();
                        break;
                    }
                    case 4:{
                        //Delete
                       deleteInCLIHelper();
                        break;
                    }
                    default:
                        System.out.println("Invalid input, try again");

                }
            } catch (InputMismatchException e){
                System.out.println("Invalid input, try Again" + "\n");
                try {
                    Thread.sleep(500);
                }catch (Exception exception){
                    System.out.println("Something went wrong, try again");
                }
                myScanner.nextLine();
            }
        }
    }

    private void makeRepositories(CRUDRepository<?>[] crudInterfaces){

        for (CRUDRepository<?> crudRepository : crudInterfaces){
            if (crudRepository.getIdentifier().equalsIgnoreCase("Student")){
                studentRepository = (CRUDRepository<Student>) crudRepository;
            }
        }

        if (studentRepository == null){
            throw new IllegalArgumentException("Repository array does not contain all necessary repositories");
        }

        for (CRUDRepository<?> crudRepository : crudInterfaces){
            if (crudRepository.getIdentifier().equalsIgnoreCase("Subject")){
                subjectRepository = (CRUDRepository<Subject>) crudRepository;
            }
        }

        if (subjectRepository == null){
            throw new IllegalArgumentException("Repository array does not contain all necessary repositories");
        }

        for (CRUDRepository<?> crudRepository : crudInterfaces){
            if (crudRepository.getIdentifier().equalsIgnoreCase("Evaluation")){
                evaluationRepository = (CRUDRepository<Evaluation>) crudRepository;
            }
        }

        if (evaluationRepository == null){
            throw new IllegalArgumentException("Repository array does not contain all necessary repositories");
        }
    }

    private void createInCLIHelper() {
        Scanner myScanner = new Scanner(System.in);

        System.out.println("Choose what you want to createInCLIHelper:");
        System.out.println("1. Student");
        System.out.println("2. Subject");
        System.out.println("3. Evaluation");
        int choice = myScanner.nextInt();

                switch (choice) {
                    //Student
                    case 1: {
                        System.out.print("Enter student name:");
                        String name = myScanner.next();
                        String name2 = myScanner.nextLine();

                        studentRepository.create(new Student(name + " " + name2));
                        break;
                    }
                    //Subject
                    case 2: {
                        System.out.print("Enter subject name:");
                        String name = myScanner.next();

                        subjectRepository.create(new Subject(name));
                        break;
                    }
                    //Evaluation
                    case 3: {
                        System.out.println("\nEnter evaluation name:\n");
                        String name = myScanner.next();
                        String name2 = myScanner.nextLine();
                        System.out.println("\nEnter evaluation subject:\n");
                        String subject = myScanner.next();
                        System.out.println("\nEnter evaluation student:\n");
                        String student = myScanner.next();
                        System.out.println("\nChoose evaluation type:\n");
                        System.out.println("1. Final Evaluation\n");
                        System.out.println("2. Oral Exam\n");
                        System.out.println("3. Practical Work\n");
                        System.out.println("4. Written Exam\n");

                        choice = myScanner.nextInt();

                        switch (choice) {
                            case 1:
                                evaluationRepository.create(new FinalEvaluation(name + " " + name2, subject, "Final Evaluation", student));
                                break;
                            case 2:
                                evaluationRepository.create(new OralExam(name + " " + name2, subject, "Oral Exam", student));
                                break;
                            case 3:
                                evaluationRepository.create(new PracticalWork(name + " " + name2, subject, "Practical Work", student));
                                break;
                            case 4:
                                evaluationRepository.create(new WrittenExam(name + " " + name2, subject, "Written Exam", student));
                                break;
                            default:
                                System.out.println("Invalid input, try again");
                        }

                        break;
                    }
                    default:
                        System.out.println("Invalid input, try again");
                }

    }

    private void readInCLIHelper(){
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Choose what you want to read:" + "\n");
        System.out.println("1. Student");
        System.out.println("2. Subject");
        System.out.println("3. Evaluation");
        int choice = myScanner.nextInt();

        switch (choice) {
            //Student
            case 1:{
                System.out.println("Enter ID:\n");
                int id = myScanner.nextInt();

                Student studentToRead = studentRepository.read(id);
                if (studentToRead != null){
                    System.out.println("\nStudent: " + studentToRead.getName());
                }else{
                    System.out.println("Invalid ID");
                }
                break;
            }
            //Subject
            case 2:{
                System.out.println("Enter ID:\n");
                int id = myScanner.nextInt();

                Subject subjectToRead = subjectRepository.read(id);
                if (subjectToRead != null){
                    System.out.println("\nSubject: " + subjectToRead.getName());
                }else{
                    System.out.println("Invalid ID");
                }
                break;
            }
            case 3:{
                System.out.println("Enter ID:\n");
                int id = myScanner.nextInt();

                Evaluation evaluationToRead = evaluationRepository.read(id);
                if (evaluationToRead != null){
                    System.out.println("Evaluation: " + evaluationToRead.getName());
                    System.out.println("Type: " + evaluationToRead.getType());
                    System.out.println("Subject: " + evaluationToRead.getSubject());
                    System.out.println("\nStudent: " + evaluationToRead.getStudent());
                }else{
                    System.out.println("Invalid ID");
                }
                break;
            }
            default:
                System.out.println("Invalid input, try again");
        }
    }

    private void updateInCLIHelper(){
        Scanner myScanner = new Scanner(System.in);

        System.out.println("Choose what you want to update:" + "\n");
        System.out.println("1. Student");
        System.out.println("2. Subject");
        System.out.println("3. Evaluation");
        int choice = myScanner.nextInt();

        switch (choice){
            case 1:{
                System.out.println("Enter ID of student to update:");
                int id = myScanner.nextInt();
                System.out.println("Enter name of new student:");
                String name = myScanner.next();
                String name2 = myScanner.nextLine();

                studentRepository.update(id, new Student(name + " " + name2));
                break;
            }
            case 2:{
                System.out.println("Enter ID of subject to update:");
                int id = myScanner.nextInt();
                System.out.println("Enter name of new subject:");
                String name = myScanner.next();


                subjectRepository.update(id, new Subject(name));
                break;
            }
            case 3:{
                System.out.println("Enter ID of evaluation to update:");
                int id = myScanner.nextInt();

                System.out.println("Enter new evaluation name:\n");
                String name = myScanner.next();
                String name2 = myScanner.nextLine();
                System.out.println("Enter new evaluation subject:\n");
                String subject = myScanner.next();
                System.out.println("Enter new evaluation student:\n");
                String student = myScanner.next();
                System.out.println("Choose new evaluation type:\n");
                System.out.println("1. Final Evaluation");
                System.out.println("2. Oral Exam");
                System.out.println("3. Practical Work");
                System.out.println("4. Written Exam");

                 choice = myScanner.nextInt();

                switch (choice) {
                    case 1:
                        evaluationRepository.update(id, new FinalEvaluation(name + " " + name2, subject, "Final Evaluation", student));
                        break;
                    case 2:
                        evaluationRepository.update(id, new OralExam(name + " " + name2, subject, "Oral Exam", student));
                        break;
                    case 3:
                        evaluationRepository.update(id,new PracticalWork(name + " " + name2, subject, "Practical Work", student));
                        break;
                    case 4:
                        evaluationRepository.update(id,new WrittenExam(name + " " + name2, subject, "Written Exam", student));
                        break;
                    default:
                        System.out.println("Invalid input, try again");
                }
                break;
            }
            default:
                System.out.println("Invalid input, try again");
        }
    }

    private void deleteInCLIHelper(){

        Scanner myScanner = new Scanner(System.in);

        System.out.println("Choose what you want to update:" + "\n");
        System.out.println("1. Student");
        System.out.println("2. Subject");
        System.out.println("3. Evaluation");
        int choice = myScanner.nextInt();
        System.out.println("Enter ID:");
        int id = myScanner.nextInt();
        switch (choice){
            case 1:{
                studentRepository.delete(id);
                break;
            }
            case 2:{
                subjectRepository.delete(id);
                break;
            }
            case 3:{
                evaluationRepository.delete(id);
                break;
            }
            default:
                System.out.println("Invalid input, try again");

        }
    }

}