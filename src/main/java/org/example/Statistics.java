package org.example;

import org.example.enums.StudyProfile;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Statistics {
    private StudyProfile profile;
    private float avgScore;
    private int amountOfStudents;
    private int amountOfUniversities;
    private List<University> universitiesList;

    Statistics() {
    }

    public StudyProfile getProfile() {
        return profile;
    }

    public void setProfile(StudyProfile profile) {
        this.profile = profile;
    }

    public float getAvgScore() {
        return avgScore;
    }

    public void setAvgScore(float avgScore) {
        this.avgScore = avgScore;
    }

    public int getAmountOfStudents() {
        return amountOfStudents;
    }

    public void setAmountOfStudents(int amountOfStudents) {
        this.amountOfStudents = amountOfStudents;
    }

    public int getAmountOfUniversities() {
        return amountOfUniversities;
    }

    public void setAmountOfUniversities(int amountOfUniversities) {
        this.amountOfUniversities = amountOfUniversities;
    }

    public List<University> getUniversitiesList() {
        return universitiesList;
    }

    public void setUniversitiesList(List<University> universitiesList) {
        this.universitiesList = universitiesList;
        this.amountOfUniversities = universitiesList.size();
    }

    public String universitiesListToString() {
         String universitiesListString = universitiesList.stream()
                 .map(University::getFullName)
                 .collect(Collectors.joining("; "));
         return universitiesListString;
    }
}
