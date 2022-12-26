package org.example;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JsonFileWriter {
    private static final Logger logger = Logger.getLogger(JsonFileWriter.class.getName());

    public JsonFileWriter() {}

    public static void jsonWriter(AllInfo allInfo) {
        logger.log(Level.INFO, "Starting json writer...");
        try {
            Files.createDirectory(Paths.get("jsonReqs"));
            logger.log(Level.INFO, "Directory created successfully");
        } catch (IOException e) {
            logger.log(Level.FINE, "Directory already exists...");
        }

        writeStudents(allInfo);
        writeUniversities(allInfo);
        writeStats(allInfo);

        logger.log(Level.INFO, "Json files writing finished successfully");
    }

    private static void writeStudents(AllInfo allInfo) {
        String studentsJson = JsonUtil.writeToGson(allInfo.getStudentList());
        try {
            logger.log(Level.INFO, "Writing students json file...");
            FileOutputStream outputStream = new FileOutputStream("jsonReqs/students" + allInfo.getCurrentDate().getTime() + ".json");
            outputStream.write(studentsJson.getBytes(StandardCharsets.UTF_8));
            outputStream.close();
            logger.log(Level.INFO, "Students json file has been written successfully.");
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Failed to write students json file.", e);
        }
    }

    private static void writeUniversities(AllInfo allInfo) {
        String universityJson = JsonUtil.writeToGson(allInfo.getUniversityList());
        try {
            logger.log(Level.INFO, "Writing universities json file...");
            FileOutputStream outputStream = new FileOutputStream("jsonReqs/universities" + allInfo.getCurrentDate().getTime() + ".json");
            outputStream.write(universityJson.getBytes(StandardCharsets.UTF_8));
            outputStream.close();
            logger.log(Level.INFO, "Universities json file has been written successfully.");
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Failed to write universities json file.", e);
        }
    }

    private static void writeStats(AllInfo allInfo) {
        String statsJson = JsonUtil.writeToGson(allInfo.getStatisticsList());
        try {
            logger.log(Level.INFO, "Writing statistics to json file...");
            FileOutputStream outputStream = new FileOutputStream("jsonReqs/statistics" + allInfo.getCurrentDate().getTime() + ".json");
            outputStream.write(statsJson.getBytes(StandardCharsets.UTF_8));
            outputStream.close();
            logger.log(Level.INFO, "Statistics json file has been written successfully.");
        } catch(IOException e) {
            logger.log(Level.SEVERE, "Failed to write statistics to json file.");
        }
    }
}
