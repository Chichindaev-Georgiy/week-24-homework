package org.example;

import org.example.enums.StudentComparatorType;
import org.example.enums.UniversityComparatorType;

import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;


public class Main {
    public static void main(String[] args) throws IOException {

        List<Student> students = XlsReader.readXlsStudents("src/main/resources/universityInfo.xlsx");
        Stream<Student> studentStream = students.stream();
        studentStream.sorted(UtilGetComparator.getStudentComparator(StudentComparatorType.AVG_EXAM_SCORE)).forEach(System.out::println);
        String studentsJson = JsonUtil.studentsListToJson(students);
        System.out.println(studentsJson);
        List<Student> studentsFromJson = JsonUtil.jsonToStudentsList(studentsJson);
        System.out.println(studentsFromJson.size() == students.size());
        students.forEach(student -> {
            String studentJson = JsonUtil.studentToJson(student);
            System.out.println(studentJson);
            Student studentFromJson = JsonUtil.jsonToStudent(studentJson);
            System.out.println(studentFromJson);
        });

        List<University> universities = XlsReader.readXlsUniversities("src/main/resources/universityInfo.xlsx");
        Stream<University> universityStream = universities.stream();
        universityStream.sorted(UtilGetComparator.getUniversityComparator(UniversityComparatorType.FOUNDATION_YEAR)).forEach(System.out::println);
        String universitiesJson = JsonUtil.universitiesListToJson(universities);
        System.out.println(universitiesJson);
        List<University> universitiesFromJson = JsonUtil.jsonToUniversityList(universitiesJson);
        System.out.println(universitiesFromJson.size() == universities.size());
        universities.forEach(university -> {
            String universityJson = JsonUtil.universityToJson(university);
            System.out.println(universityJson);
            University universityFromJson = JsonUtil.jsonToUniversity(universityJson);
            System.out.println(universityFromJson);
        });

        List<Statistics> stats = StatisticsUtil.getStatistics(students, universities);
        XlsWriter.writeStats(stats, "stats.xlsx");
    }
}