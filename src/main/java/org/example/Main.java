package org.example;

import org.example.enums.StudentComparatorType;
import org.example.enums.UniversityComparatorType;

import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;


public class Main {
    public static void main(String[] args) throws IOException {

        List<Student> students = ReadSpreadSheet.readXlsStudents("src/main/resources/universityInfo.xlsx");
        Stream<Student> studentStream = students.stream();
        studentStream.sorted(UtilGetComparator.getStudentComparator(StudentComparatorType.AVG_EXAM_SCORE)).forEach(System.out::println);


        List<University> universities = ReadSpreadSheet.readXlsUniversities("src/main/resources/universityInfo.xlsx");
        Stream<University> universityStream = universities.stream();
        universityStream.sorted(UtilGetComparator.getUniversityComparator(UniversityComparatorType.FOUNDATION_YEAR)).forEach(System.out::println);
    }
}