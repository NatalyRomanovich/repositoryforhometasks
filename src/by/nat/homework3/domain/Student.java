package by.nat.homework3.domain;

import java.util.Comparator;
import java.util.Objects;

public class Student implements Comparator<Student>, Comparable<Student> {

    private Integer id;
    private String studentSurName;
    private String studentName;

    public Student() {
    }

    public Student(Integer id, String studentSurName, String studentName) {
        this.id = id;
        this.studentSurName = studentSurName;
        this.studentName = studentName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStudentSurName() {
        return studentSurName;
    }

    public void setStudentSurName(String studentSurName) {
        this.studentSurName = studentSurName;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    @Override
    public int compare(Student o1, Student o2) {
        return o1.getStudentSurName().compareTo(o2.getStudentSurName());

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(id, student.id) && Objects.equals(studentSurName, student.studentSurName) && Objects.equals(studentName, student.studentName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, studentSurName, studentName);
    }

    @Override
    public String toString() {
        return "Student: " +
                "id=" + id +
                ", studentSurName='" + studentSurName + '\'' +
                ", studentName='" + studentName + '\'';
    }

    @Override
    public int compareTo(Student o) {
        return this.getStudentSurName().compareTo(o.studentSurName);
    }
}

