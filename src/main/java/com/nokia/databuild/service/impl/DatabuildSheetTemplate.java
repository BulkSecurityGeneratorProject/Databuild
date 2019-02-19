package com.nokia.databuild.service.impl;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class DatabuildSheetTemplate {
    private final DatabuildSheet workbook;
    private Map<String, Integer> columnIndex;

    public Map<String, Integer> getColumnIndex() {
        return columnIndex;
    }

    public DatabuildSheetTemplate(XSSFWorkbook workbook) {
        this.workbook = new DatabuildSheet(workbook);
        columnIndex = new HashMap<>();

        Sheet datatypeSheet = workbook.getSheetAt(0);
        Row currentRow = datatypeSheet.getRow(0);
        Iterator<Cell> cellIterator = currentRow.iterator();
        while (cellIterator.hasNext()) {
            Cell currentCell = cellIterator.next();
            String columnName = currentCell.getStringCellValue();
            Integer columnInd = currentCell.getColumnIndex();
            columnIndex.put(columnName, columnInd);
        }
    }

    public void setCellValue(int sheetIndex, int rowNum, int cellIndex, String cellValue) {
        workbook.setCellValue(sheetIndex, rowNum, cellIndex, cellValue);
    }

    public void setCellValue(int sheetIndex, int rowNum, int cellIndex, int cellValue) {
        workbook.setCellValue(sheetIndex, rowNum, cellIndex, cellValue);
    }

    public byte[] write() throws IOException {
        return workbook.write();
    }

    public String getCellValue(int sheetIndex, int rowNum, int cellIndex) {
        return workbook.getCellValue(sheetIndex, rowNum, cellIndex);
    }
}
