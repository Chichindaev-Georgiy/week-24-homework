package org.example;

import org.example.enums.StudyProfile;

import java.math.BigDecimal;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class StatisticsUtil {
    private static final Logger logger = Logger.getLogger(StatisticsUtil.class.getName());
    private StatisticsUtil() {
    }

    public static List<Statistics> getStatistics(List<Student> students, List<University> universities) {
        logger.log(Level.INFO, "Starting generating statistics...");
        List<Statistics> statisticsList = new ArrayList<>();
        Set<StudyProfile> profiles = universities.stream().
                map(University::getMainProfile).
                collect(Collectors.toSet());

        profiles.forEach(profile -> {
            Statistics stat = new Statistics();
            statisticsList.add(stat);
            stat.setProfile(profile);
            List<String> universityIds = universities.stream()
                    .filter(university -> university.getMainProfile().equals(profile))
                    .map(University::getId)
                    .collect(Collectors.toList());
            stat.setAmountOfUniversities(universityIds.size());
            List<University> profileUniversitiesList = universities.stream()
                            .filter(university -> university.getMainProfile().equals(profile))
                                    .collect(Collectors.toList());
            stat.setUniversitiesList(profileUniversitiesList);
            List<Student> profileStudents = students.stream()
                            .filter(student -> universityIds.contains(student.getUniversityId()))
                                    .collect(Collectors.toList());
            stat.setAmountOfStudents(profileStudents.size());
            OptionalDouble avgExamScore = profileStudents.stream()
                    .mapToDouble(Student::getAvgExamScore)
                    .average();
            stat.setAvgScore(0);
            avgExamScore.ifPresent(value -> stat.setAvgScore(
                    BigDecimal.valueOf(value).setScale(2, BigDecimal.ROUND_HALF_UP).floatValue()
            ));
        });

        logger.log(Level.INFO, String.format("Statistics done with %d statistical objects.", statisticsList.size()));

        return statisticsList;
    }
}
