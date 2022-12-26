package org.example;

import org.example.enums.StudyProfile;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.List;
import java.util.stream.Collectors;

@XmlAccessorType(XmlAccessType.FIELD)
public class Statistics {
    @XmlElement(name = "universityProfile")
    private StudyProfile profile;
    @XmlElement(name = "avgExamScore")
    private float avgScore;
    @XmlTransient
    private int amountOfStudents;
    @XmlTransient
    private int amountOfUniversities;
    @XmlTransient
    private List<University> universitiesList;

    Statistics() {
    }

    public StudyProfile getProfile() {
        return profile;
    }

    public Statistics setProfile(StudyProfile profile) {
        this.profile = profile;
        return this;
    }

    public float getAvgScore() {
        return avgScore;
    }

    public Statistics setAvgScore(float avgScore) {
        this.avgScore = avgScore;
        return this;
    }

    public int getAmountOfStudents() {
        return amountOfStudents;
    }

    public Statistics setAmountOfStudents(int amountOfStudents) {
        this.amountOfStudents = amountOfStudents;
        return this;
    }

    public int getAmountOfUniversities() {
        return amountOfUniversities;
    }

    public Statistics setAmountOfUniversities(int amountOfUniversities) {
        this.amountOfUniversities = amountOfUniversities;
        return this;
    }

    public List<University> getUniversitiesList() {
        return universitiesList;
    }

    public Statistics setUniversitiesList(List<University> universitiesList) {
        this.universitiesList = universitiesList;
        this.amountOfUniversities = universitiesList.size();
        return this;
    }

    public String universitiesListToString() {
         String universitiesListString = universitiesList.stream()
                 .map(University::getFullName)
                 .collect(Collectors.joining("; "));
         return universitiesListString;
    }
}
