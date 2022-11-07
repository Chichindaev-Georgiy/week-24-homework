package org.example;

public enum StudyProfile {
    MEDICINE("Медицина"),
    ENGINEERING("Технические специальности"),
    PHILOSOPHY("Философия"),
    MATH("Математический уклон"),
    PHYSICS("Физические науки");

    private String profileName;
    StudyProfile(String profileName) {
        this.profileName = profileName;
    }

    public String getProfileName() {
        return profileName;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

    @Override
    public String toString() {
        return "StudyProfile{" +
                "profileName='" + profileName + '\'' +
                '}';
    }
}
