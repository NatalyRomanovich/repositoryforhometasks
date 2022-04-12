package by.nat.homework3.util;

import by.nat.homework3.domain.Student;
import by.nat.homework3.domain.StudentInformation;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class GeneratorStudents implements StudentInformation {

    public static Set getStudent() {
        TreeSet<Student> setOfStudents = new TreeSet<>();
        int i = 0;
        while (setOfStudents.size() < STUDETS_NAMES.length) {
            i++;
            int randomIndex = (int) (Math.random() * (STUDETS_NAMES.length));
            Student student = new Student(i + 1, STUDETS_SURNAMES[randomIndex], STUDETS_NAMES[randomIndex]);
            setOfStudents.add(student);
        }
        return setOfStudents;
    }

    public static void removingEvenElements(Set<Student> setOfStudents) {

        List<Student> arrayForCheckEvenElements = new ArrayList<>(setOfStudents);

        for (int i = 0; i < STUDETS_NAMES.length; i++) {
            int id = arrayForCheckEvenElements.get(i).getId();

            //parity check
            if (id % 2 != 0) {
                Student student = arrayForCheckEvenElements.get(i);
                setOfStudents.remove(student);
            }
        }
    }

}
