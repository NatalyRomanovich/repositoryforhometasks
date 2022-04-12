package by.nat.homework3.test;


import by.nat.homework3.domain.Student;
import by.nat.homework3.domain.StudentInformation;
import by.nat.homework3.util.GeneratorStudents;
import by.nat.homework3.util.OutputOnDisplay;

import java.util.TreeSet;

public class TestStudent implements StudentInformation {
    public static void main(String[] args) {

        //Generate a TreeSet of students in random order
        TreeSet<Student> setOfStudents = (TreeSet<Student>) GeneratorStudents.getStudent();
        System.out.println("The set of all students: "+ "\n");
        OutputOnDisplay.showObject(setOfStudents);

        //Remove students with even id
        GeneratorStudents.removingEvenElements(setOfStudents);
        System.out.println("\n"+ "The set of students with even id: "+ "\n");
        OutputOnDisplay.showObject(setOfStudents);
    }
}
