package org.example;

import org.example.enums.StudentComparatorType;
import org.example.enums.UniversityComparatorType;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import java.util.stream.Stream;


public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());
    public static void main(String[] args) throws IOException {
        try {
            LogManager.getLogManager().readConfiguration(Main.class.getResourceAsStream("/logging.properties"));
        } catch (IOException e) {
            System.err.println("Couldn't setup logger configuration: " + e.toString());
        }
        logger.log(Level.INFO, "Logger configured.");

        List<Student> students = XlsReader.readXlsStudents("src/main/resources/universityInfo.xlsx");
        Stream<Student> studentStream = students.stream();
        studentStream.sorted(UtilGetComparator.getStudentComparator(StudentComparatorType.AVG_EXAM_SCORE));

        List<University> universities = XlsReader.readXlsUniversities("src/main/resources/universityInfo.xlsx");
        Stream<University> universityStream = universities.stream();
        universityStream.sorted(UtilGetComparator.getUniversityComparator(UniversityComparatorType.FOUNDATION_YEAR));

        List<Statistics> stats = StatisticsUtil.getStatistics(students, universities);
        XlsWriter.writeStats(stats, "stats.xlsx");

        AllInfo allInfo = new AllInfo()
                .setStudentList(students)
                .setUniversityList(universities)
                .setStatisticsList(stats)
                .setCurrentDate(new Date());

        XmlWriter.xmlGenerator(allInfo);
        JsonFileWriter.jsonWriter(allInfo);

        logger.log(Level.INFO, "End of program.");
    }
}