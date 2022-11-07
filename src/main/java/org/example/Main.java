package org.example;

public class Main {
    public static void main(String[] args) {
        Student student = new Student("Иуанов Ыван", "14", 3, 3.3f);
        System.out.println(student);
        University university = new University("14", "ПТУ №5 имени Петра Петрова", "ПТУх №5", 1972, StudyProfile.ENGINEERING);
        student.setFullName("Иванов Иван");
        student.setAvgExamScore(4.5f);
        System.out.println(student);
        System.out.println(university);
        university.setShortName("ПТУ №5");
        System.out.println(university);
    }
}