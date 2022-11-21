package org.example;

import org.example.enums.StudentComparatorType;
import org.example.comparators.*;
import org.example.enums.UniversityComparatorType;


public class UtilGetComparator {
    private UtilGetComparator() {
    }

    public static StudentComparator getStudentComparator(StudentComparatorType enumType) {
        switch(enumType) {
            case COURSE_NUMBER:
                return new StudentCurrentCourseNumberComparator();
            case UNIVERSITY_ID:
                return new StudentUniversityIdComparator();
            case AVG_EXAM_SCORE:
                return new StudentAvgExamScoreComparator();
            case FULL_NAME:
            default:
                return new StudentFullNameComparator();
        }
    }

    public static UniversityComparator getUniversityComparator(UniversityComparatorType enumType) {
        switch (enumType) {
            case ID:
                return new UniversityIdComparator();
            case PROFILE:
                return new UniversityProfileComparator();
            case SHORT_NAME:
                return new UniversityShortNameComparator();
            case FOUNDATION_YEAR:
                return new UniversityYearOfFoundationComparator();
            case FULL_NAME:
            default:
                return new UniversityFullNameComparator();
        }
    }
}
