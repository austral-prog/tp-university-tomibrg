package com.university;

import com.university.person.Student;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;


public class App {
    public static void main(String[] args) {
    String inputPath = "src/main/resources/input.csv";
    Student myStudent = new Student("John Doe", "johndoe@org.com");
    ArrayList<ArrayList<String>> dataList = new ArrayList<ArrayList<String>>();
    HashMap<String, Student> studentMap = new HashMap<String, Student>();

    try (BufferedReader inputReader = new BufferedReader(new FileReader(inputPath))){
        String inputLine;

        while((inputLine = inputReader.readLine()) != null){
            String currentWord = "";
            ArrayList<String> lineList = new ArrayList<String>();
            for (Character i : inputLine.toCharArray()){
                if (!i.toString().equals(",")){
                    currentWord += i;
                }
                else{
                    lineList.add(currentWord.strip());
                    currentWord = "";
                }
            }
            dataList.add(lineList);

        }
    }
    catch(IOException e){
        e.printStackTrace();
        }

    dataList.removeFirst();
    for (ArrayList<String> studentData : dataList){
        if (!studentMap.containsKey(studentData.get(2))){
            studentMap.put(studentData.get(2),new Student(studentData.get(2), studentData.get(3)));
            studentMap.get(studentData.get(2)).addCourse(studentData.get(1));
        }
        else{
            Student currentStudent = studentMap.get(studentData.get(2));
            currentStudent.addCourse(studentData.get(1));
        }
    }
    myStudent = myStudent.getStudentsList().get(1);
    myStudent.getStudentsList().removeFirst();



    try {
        File solution = new File("src\\main\\resources\\students.csv");
        FileWriter solutionWriter = new FileWriter("src\\main\\resources\\solution.csv"); //Si falla fijate aca.
        solutionWriter.write("Student_Name,Course_Count\n");
        for (Student student : myStudent.getSortedStudentsTypedList()) {
            Integer currentCourseCount = student.getCourseList().size();
            solutionWriter.write(student.getName() + "," + currentCourseCount.toString() + "\n");
        }
        solutionWriter.write("\n");
        solutionWriter.close();
    } catch (IOException i){
        i.printStackTrace();
    }
    }

}
