package com.nokia.databuild.service.impl;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import static org.apache.poi.ss.usermodel.Row.MissingCellPolicy.CREATE_NULL_AS_BLANK;

public class DatabuildSheetGolden {

    private final DatabuildSheet workbook;

    public Map<String, String> getGoldenParamsMap() {
        return goldenParamsMap;
    }

    private Map<String, String> goldenParamsMap;

    public DatabuildSheetGolden(XSSFWorkbook workbook) {
        this.workbook = new DatabuildSheet(workbook);
        goldenParamsMap = new HashMap<>();

        Sheet datatypeSheet = workbook.getSheetAt(0);
        Iterator<Row> iterator = datatypeSheet.iterator();
        while (iterator.hasNext()) {
            Row currentRow = iterator.next();
            if (currentRow.getRowNum() == 0) {
                continue; //just skip the rows if row number is 0
            }
            if(currentRow.getCell(0) != null && currentRow.getCell(1) != null){
                String paramName = readCell(currentRow.getCell(0));
                String paramValue = readCell(currentRow.getCell(1));
                goldenParamsMap.put(paramName, paramValue);
            }
        }
    }

    public static String readCell(Cell currentCell){
        String val = "";
        if (currentCell.getCellType() == CellType.STRING) {
            val =  currentCell.getStringCellValue();
        } else if (currentCell.getCellType() == CellType.NUMERIC) {
            val =  ""+currentCell.getNumericCellValue();
        }
        return val;
    }

    public void setCellValue(int sheetIndex, int rowNum, int cellIndex, String cellValue) {
        workbook.setCellValue(sheetIndex, rowNum, cellIndex, cellValue);
    }

    public byte[] write() throws IOException {
        return workbook.write();
    }

    public String getCellValue(int sheetIndex, int rowNum, int cellIndex) {
        return workbook.getCellValue(sheetIndex, rowNum, cellIndex);
    }

}
