package com.nokia.databuild.service.impl;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

import static org.apache.poi.ss.usermodel.Row.MissingCellPolicy.CREATE_NULL_AS_BLANK;

class DatabuildSheet {

    private final Workbook workbook;

    public DatabuildSheet(XSSFWorkbook workbook) {
        this.workbook = workbook;
    }

    public void setCellValue(int sheetIndex, int rowNum, int cellIndex, String cellValue) {
        Sheet sheet = workbook.getSheetAt(sheetIndex);
        Row r = sheet.getRow(rowNum);
        if (r == null) {
            r = sheet.createRow(rowNum);
        }

        Cell c = r.getCell(cellIndex, CREATE_NULL_AS_BLANK);
        c.setCellValue(cellValue);

    }

    public void setCellValue(int sheetIndex, int rowNum, int cellIndex, int cellValue) {
        Sheet sheet = workbook.getSheetAt(sheetIndex);
        Row r = sheet.getRow(rowNum);
        if (r == null) {
            r = sheet.createRow(rowNum);
        }

        Cell c = r.getCell(cellIndex, CREATE_NULL_AS_BLANK);
        c.setCellValue(cellValue);

    }

    public byte[] write() throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        workbook.write(baos);
        return baos.toByteArray();
    }

    public String getCellValue(int sheetIndex, int rowNum, int cellIndex) {
        Sheet sheet = workbook.getSheetAt(sheetIndex);
        Row r = sheet.getRow(rowNum);
        if (r == null) {
            r = sheet.createRow(rowNum);
        }

        Cell c = r.getCell(cellIndex, CREATE_NULL_AS_BLANK);
        return c.getStringCellValue();
    }
}
