package com.javarush.test.level29.lesson15.big01.human;

import java.util.ArrayList;
import java.util.List;

public class University{

    private List<Student> students = new ArrayList<>();
    private String name;
    private int age;

    public University(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Student getStudentWithAverageGrade(double averageGrade) {
        Student result = null;
        for (Student student : students) {
            if (student.getAverageGrade() == averageGrade){
                result = student;
                break;
            }
        }
        return result;
    }

    public Student getStudentWithMaxAverageGrade() {
        Student studentWithMaxAverageGrade = null;
        double maxAverageGrade = 0.0;
        for (Student student : students) {
            if (student.getAverageGrade() > maxAverageGrade) {
                studentWithMaxAverageGrade = student;
                maxAverageGrade = student.getAverageGrade();
            }
        }
        return studentWithMaxAverageGrade;
    }

    public Student getStudentWithMinAverageGrade() {
        Student studentWithMinAverageGrade = null;
        double minAverageGrade = Double.MAX_VALUE;
        for (Student student : students) {
            if (student.getAverageGrade() < minAverageGrade) {
                studentWithMinAverageGrade = student;
                minAverageGrade = student.getAverageGrade();
            }
        }
        return studentWithMinAverageGrade;
    }

    public void expel(Student student) {
        students.remove(student);
    }
}
