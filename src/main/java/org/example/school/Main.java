package org.example.school;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        userInput();
        Student stu = new GraduateStudent("test", 60, 80, 65);
        stu.print();
    }

    private static void userInput() {
        Scanner scanner = new Scanner(System.in);
        String name;
        int englishGrade, mathGrade;
        System.out.print("Enter the student's name: ");
        name = scanner.next();
        System.out.print("Enter the student's English grade: ");
        englishGrade = scanner.nextInt();
        System.out.print("Enter the student's Math grade: ");
        mathGrade = scanner.nextInt();
        Student student = new Student(name, englishGrade, mathGrade);
        student.print();
    }
}
