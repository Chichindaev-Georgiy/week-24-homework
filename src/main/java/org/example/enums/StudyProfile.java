package org.example.enums;

public enum StudyProfile {
    MEDICINE("Медицина"),
    ENGINEERING("Технические специальности"),
    PHILOSOPHY("Философия"),
    MATHEMATICS("Математический уклон"),
    PHYSICS("Физические науки"),
    LINGUISTICS("Лингвистика");

    private final String profileName;
    private StudyProfile(String profileName) {
        this.profileName = profileName;
    }

    public String getProfileName() {
        return profileName;
    }


    @Override
    public String toString() {
        return "StudyProfile{" +
                "profileName='" + profileName + '\'' +
                '}';
    }
}
