package org.example;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class XlsWriter {
    private static final Logger logger = Logger.getLogger(XlsWriter.class.getName());
    private XlsWriter() {
    }

    public static void writeStats(List<Statistics> statisticsList, String fileName) {

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet1 = workbook.createSheet("Статистика");

        XSSFFont headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerFont.setFontHeightInPoints((short)15);
        headerFont.setFontName("Arial");
        XSSFCellStyle headerStyle = workbook.createCellStyle();
        headerStyle.setFont(headerFont);

        int rowNumber = 0;
        int cellNumber = 0;
        Row headerRow = sheet1.createRow(rowNumber++);
        Cell headerProfileCell = headerRow.createCell(cellNumber);
        headerProfileCell.setCellValue("Профиль");
        headerProfileCell.setCellStyle(headerStyle);
        sheet1.autoSizeColumn(cellNumber++);
        Cell headerAvgScore = headerRow.createCell(cellNumber);
        headerAvgScore.setCellValue("Средний балл");
        headerAvgScore.setCellStyle(headerStyle);
        sheet1.autoSizeColumn(cellNumber++);
        Cell headerNumbOfStudents = headerRow.createCell(cellNumber);
        headerNumbOfStudents.setCellValue("Кол-во студентов");
        headerNumbOfStudents.setCellStyle(headerStyle);
        sheet1.autoSizeColumn(cellNumber++);
        Cell headerNumbOfUniversities = headerRow.createCell(cellNumber);
        headerNumbOfUniversities.setCellValue("Кол-во университетов по профилю");
        headerNumbOfUniversities.setCellStyle(headerStyle);
        sheet1.autoSizeColumn(cellNumber++);
        Cell headerUniversitiesList = headerRow.createCell(cellNumber);
        headerUniversitiesList.setCellValue("Университеты профиля");
        headerUniversitiesList.setCellStyle(headerStyle);
        sheet1.autoSizeColumn(cellNumber++);

        for (Statistics statistics: statisticsList
             ) {
            Row aRow = sheet1.createRow(rowNumber++);
            cellNumber = 0;
            Cell profCell = aRow.createCell(cellNumber);
            profCell.setCellValue(statistics.getProfile().getProfileName());
            sheet1.autoSizeColumn(cellNumber++);
            Cell avgScoreCell = aRow.createCell(cellNumber++);
            avgScoreCell.setCellValue(statistics.getAvgScore());
            Cell studentsNumCell = aRow.createCell(cellNumber++);
            studentsNumCell.setCellValue(statistics.getAmountOfStudents());
            Cell universitiesNumCell = aRow.createCell(cellNumber++);
            universitiesNumCell.setCellValue(statistics.getAmountOfUniversities());
            Cell universitiesListCell = aRow.createCell(cellNumber);
            universitiesListCell.setCellValue(statistics.universitiesListToString());
            sheet1.autoSizeColumn(cellNumber);
        }
        FileOutputStream fileOut = null;
        logger.log(Level.INFO, "Start writing file...");
        try {
            fileOut = new FileOutputStream(fileName);
            workbook.write(fileOut);
            fileOut.close();
        } catch (IOException e) {
            logger.log(Level.SEVERE, "File writing error", e);
        }
        logger.log(Level.INFO, "File has been written successfully.");
    }
}