package org.health.track.teamhealthtrack;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelGenerator {

    public static void main(String[] args) {
        String[] columnNames = {"Name", "Age", "City", "Occupation"};

        Object[][] data = {
                {"John Doe", 25, "New York", "Software Engineer"},
                {"Jane Smith", 30, "San Francisco", "Data Scientist"},
                {"Bob Johnson", 35, "Chicago", "Teacher"}
                // Add more rows as needed
        };

        try {
            generateExcel(columnNames, data, "output.xlsx");
            System.out.println("Excel file generated successfully.");
        } catch (IOException e) {
            System.err.println("Error generating Excel file: " + e.getMessage());
        }
    }

    private static void generateExcel(String[] columnNames, Object[][] data, String outputFileName) throws IOException {
        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("Sheet1");

            // Create header row
            Row headerRow = sheet.createRow(0);
            for (int col = 0; col < columnNames.length; col++) {
                Cell cell = headerRow.createCell(col);
                cell.setCellValue(columnNames[col]);
            }

            // Populate data rows
            for (int row = 0; row < data.length; row++) {
                Row dataRow = sheet.createRow(row + 1); // Starting from the second row for data

                for (int col = 0; col < data[row].length; col++) {
                    Cell cell = dataRow.createCell(col);

                    if (data[row][col] instanceof String) {
                        cell.setCellValue((String) data[row][col]);
                    } else if (data[row][col] instanceof Number) {
                        cell.setCellValue(((Number) data[row][col]).doubleValue());
                    }
                    // Add more conditions based on the types of data you might have
                }
            }

            // Write the workbook to a file
            try (FileOutputStream fileOut = new FileOutputStream(outputFileName)) {
                workbook.write(fileOut);
            }
        }
    }
}
