package com.nokia.databuild.service.impl;

import com.nokia.databuild.domain.NewSiteCreation;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import java.io.*;
import java.util.Iterator;

@Component
public class NewSiteCreationHelper {
    private final Logger log = LoggerFactory.getLogger(NewSiteCreationHelper.class);

    public NewSiteCreation populateNeighborDatabase(NewSiteCreation newSiteCreation) {
        try {
            populateAdjg(newSiteCreation);

            populateAdji(newSiteCreation);
            populateAdjs(newSiteCreation);
            populateAdjw(newSiteCreation);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return newSiteCreation;

    }

    private void populateAdjw(NewSiteCreation newSiteCreation) throws IOException {
        if(null == newSiteCreation.getGoldenParametersAdjw()){
            return;
        }
        DatabuildSheetTemplate template = readExcel("classpath:templates/template_ADJW.xlsx");
        DatabuildSheetGolden goldenWB = new DatabuildSheetGolden(new XSSFWorkbook(new
            ByteArrayInputStream(newSiteCreation.getGoldenParametersAdjw())));


        setTemplateName(newSiteCreation, template, 4);
        template.setCellValue(0, 1, 0, newSiteCreation.getBscId());
        template.setCellValue(0, 1, 1, newSiteCreation.getBcfId());
        template.setCellValue(0, 1, 2, newSiteCreation.getBtsId());
        template.setCellValue(0, 1, 6, newSiteCreation.getAdjwCid());
        template.setCellValue(0, 1, 11, newSiteCreation.getAdjwLac());
        template.setCellValue(0, 1, 16, newSiteCreation.getAdjwRncId());
        template.setCellValue(0, 1, 18, newSiteCreation.getScramblingCode());


        goldenWB.getGoldenParamsMap().forEach((paramName, paramValue) -> {
            int colIndex = template.getColumnIndex().getOrDefault(paramName, Integer
                .MIN_VALUE);
            if (colIndex >= 0) {
                template.setCellValue(0, 1, colIndex, (int) Double.parseDouble(paramValue));
            }
        });


        newSiteCreation.setOutputAdjw(template.write());
        newSiteCreation.setOutputAdjwContentType("application/vnd.openxmlformats-officedocument" +
            ".spreadsheetml.sheet");


    }

    private void populateAdjs(NewSiteCreation newSiteCreation) throws IOException {
        if(null == newSiteCreation.getGoldenParametersAdjs()){
            return;
        }

        DatabuildSheetTemplate template = readExcel("classpath:templates/template_ADJS.xlsx");
        DatabuildSheetGolden goldenWB = new DatabuildSheetGolden(new XSSFWorkbook(new
            ByteArrayInputStream(newSiteCreation.getGoldenParametersAdjs())));


        setRncID(newSiteCreation, template, 0);
        setWbtsId(newSiteCreation, template, 1);
        setTemplateName(newSiteCreation, template, 4);
        setLcrid(newSiteCreation, template, 2);
        template.setCellValue(0, 1, 3, newSiteCreation.getAdjsId());
        template.setCellValue(0, 1, 8, newSiteCreation.getAdjsCi());
        template.setCellValue(0, 1, 12, newSiteCreation.getAdjsLac());
        template.setCellValue(0, 1, 15, newSiteCreation.getAdjsRac());
        template.setCellValue(0, 1, 16, newSiteCreation.getAdjsRnCid());
        template.setCellValue(0, 1, 18, newSiteCreation.getAdjsSrcCode());


        goldenWB.getGoldenParamsMap().forEach((paramName, paramValue) -> {
            int colIndex = template.getColumnIndex().getOrDefault(paramName, Integer
                .MIN_VALUE);
            if (colIndex >= 0) {
                template.setCellValue(0, 1, colIndex, (int) Double.parseDouble(paramValue));
            }
        });


        newSiteCreation.setOutputAdjs(template.write());
        newSiteCreation.setOutputAdjsContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");


    }

    private void populateAdji(NewSiteCreation newSiteCreation) throws IOException {
        if(null == newSiteCreation.getGoldenParametersAdji()){
            return;
        }
        DatabuildSheetTemplate template = readExcel("classpath:templates/template_ADJI.xlsx");
        DatabuildSheetGolden goldenWB = new DatabuildSheetGolden(new XSSFWorkbook(new
            ByteArrayInputStream(newSiteCreation.getGoldenParametersAdji())));


        setRncID(newSiteCreation, template, 0);
        setWbtsId(newSiteCreation, template, 1);
        setTemplateName(newSiteCreation, template, 4);
        setLcrid(newSiteCreation, template, 2);
        template.setCellValue(0, 1, 3, newSiteCreation.getAdjiId());
        template.setCellValue(0, 1, 8, newSiteCreation.getAdjiCi());
        template.setCellValue(0, 1, 13, newSiteCreation.getAdjiLac());
        template.setCellValue(0, 1, 17, newSiteCreation.getAdjiRac());
        template.setCellValue(0, 1, 18, newSiteCreation.getAdjiRnCid());
        template.setCellValue(0, 1, 20, newSiteCreation.getAdjiSrcCode());


        goldenWB.getGoldenParamsMap().forEach((paramName, paramValue) -> {
            int colIndex = template.getColumnIndex().getOrDefault(paramName, Integer
                .MIN_VALUE);
            if (colIndex >= 0) {
                template.setCellValue(0, 1, colIndex, (int) Double.parseDouble(paramValue));
            }
        });


        newSiteCreation.setOutputAdji(template.write());
        newSiteCreation.setOutputAdjiContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");

    }

    private void populateAdjg(NewSiteCreation newSiteCreation) throws IOException {
        if(null == newSiteCreation.getGoldenParametersAdjg()){
            return;
        }
        DatabuildSheetTemplate template = readExcel("classpath:templates/template_ADJG.xlsx");
        DatabuildSheetGolden goldenWB = new DatabuildSheetGolden(new XSSFWorkbook(new
            ByteArrayInputStream(newSiteCreation.getGoldenParametersAdjg())));


        setRncID(newSiteCreation, template, 0);
        setWbtsId(newSiteCreation, template, 1);
        setTemplateName(newSiteCreation, template, 4);
        setLcrid(newSiteCreation, template, 2);
        template.setCellValue(0, 1, 3, newSiteCreation.getAdjGid());
        template.setCellValue(0, 1, 8, newSiteCreation.getAdjgBcc());
        template.setCellValue(0, 1, 9, newSiteCreation.getAdjgBcch());
        template.setCellValue(0, 1, 11, newSiteCreation.getAdjgCi());
        template.setCellValue(0, 1, 12, newSiteCreation.getAdjgLac());
        template.setCellValue(0, 1, 15, newSiteCreation.getAdjgNcc());


        goldenWB.getGoldenParamsMap().forEach((paramName, paramValue) -> {
            int colIndex = template.getColumnIndex().getOrDefault(paramName, Integer
                .MIN_VALUE);
            if (colIndex >= 0) {
                template.setCellValue(0, 1, colIndex, (int) Double.parseDouble(paramValue));
            }
        });


        newSiteCreation.setOutputAdjg(template.write());
        newSiteCreation.setOutputAdjgContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");

    }

    public NewSiteCreation populateRfDatabase(NewSiteCreation newSiteCreation) {
        try {

            populateWbts(newSiteCreation);
            if(null != newSiteCreation.getGoldenParametersWcell()){
                populateWcell(newSiteCreation);
                populateWcellAc(newSiteCreation);
                populateWcellHc(newSiteCreation);
                populateWcellLc(newSiteCreation);
                populateWcellPc(newSiteCreation);
                populateWcellPS(newSiteCreation);
                populateWcellSib(newSiteCreation);
                populateWcellUraid(newSiteCreation);
            }

            populateWlcse(newSiteCreation);


        } catch (IOException e) {
            log.error(e.getMessage());
        }

        return newSiteCreation;
    }

    private void populateWcell(NewSiteCreation newSiteCreation) throws IOException {
        DatabuildSheetTemplate templateWcell = readExcel("classpath:templates/template_wcell.xlsx");
        DatabuildSheetGolden goldenWcellWB = new DatabuildSheetGolden(new XSSFWorkbook(new
            ByteArrayInputStream(newSiteCreation.getGoldenParametersWcell())));


        setRncID(newSiteCreation, templateWcell, 0);
        setWbtsId(newSiteCreation, templateWcell, 1);
        setTemplateName(newSiteCreation, templateWcell, 3);
        setLcrid(newSiteCreation, templateWcell, 2);
        setCid(newSiteCreation, templateWcell, 6);
        setWbtsName(newSiteCreation, templateWcell, 70);
        templateWcell.setCellValue(0, 1, 17, newSiteCreation.getLac());
        templateWcell.setCellValue(0, 1, 45, newSiteCreation.getRac());
        templateWcell.setCellValue(0, 1, 51, newSiteCreation.getSac());
        templateWcell.setCellValue(0, 1, 43, newSiteCreation.getPriSrcCode());


        goldenWcellWB.getGoldenParamsMap().forEach((paramName, paramValue) -> {
            int colIndex = templateWcell.getColumnIndex().getOrDefault(paramName, Integer
                .MIN_VALUE);
            if (colIndex >= 0) {
                templateWcell.setCellValue(0, 1, colIndex, (int) Double.parseDouble(paramValue));
            }
        });


        newSiteCreation.setOutputWcell(templateWcell.write());
        newSiteCreation.setOutputWcellContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");


    }

    private void populateWcellAc(NewSiteCreation newSiteCreation) throws IOException {
        DatabuildSheetTemplate templateWcellAc = readExcel("classpath:templates/template_wcell_ac" +
            ".xlsx");
        DatabuildSheetGolden goldenWcellWB = new DatabuildSheetGolden(new XSSFWorkbook(new
            ByteArrayInputStream(newSiteCreation.getGoldenParametersWcell())));


        setRncID(newSiteCreation, templateWcellAc, 0);
        setWbtsId(newSiteCreation, templateWcellAc, 1);
        setTemplateName(newSiteCreation, templateWcellAc, 3);
        setLcrid(newSiteCreation, templateWcellAc, 2);


        goldenWcellWB.getGoldenParamsMap().forEach((paramName, paramValue) -> {
            int colIndex = templateWcellAc.getColumnIndex().getOrDefault(paramName, Integer
                .MIN_VALUE);
            if (colIndex >= 0) {
                templateWcellAc.setCellValue(0, 1, colIndex, (int) Double.parseDouble(paramValue));
            }
        });


        newSiteCreation.setOutputWcellAc(templateWcellAc.write());
        newSiteCreation.setOutputWcellAcContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");


    }


    private void populateWcellHc(NewSiteCreation newSiteCreation) throws IOException {
        DatabuildSheetTemplate templateWcellHc = readExcel("classpath:templates/template_wcell_hc" +
            ".xlsx");
        DatabuildSheetGolden goldenWcellWB = new DatabuildSheetGolden(new XSSFWorkbook(new
            ByteArrayInputStream(newSiteCreation.getGoldenParametersWcell())));


        setRncID(newSiteCreation, templateWcellHc, 0);
        setWbtsId(newSiteCreation, templateWcellHc, 1);
        setTemplateName(newSiteCreation, templateWcellHc, 3);
        setLcrid(newSiteCreation, templateWcellHc, 2);


        goldenWcellWB.getGoldenParamsMap().forEach((paramName, paramValue) -> {
            int colIndex = templateWcellHc.getColumnIndex().getOrDefault(paramName, Integer
                .MIN_VALUE);
            if (colIndex >= 0) {
                templateWcellHc.setCellValue(0, 1, colIndex, (int) Double.parseDouble(paramValue));
            }
        });


        newSiteCreation.setOutputWcellHc(templateWcellHc.write());
        newSiteCreation.setOutputWcellHcContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");


    }


    private void populateWcellLc(NewSiteCreation newSiteCreation) throws IOException {
        DatabuildSheetTemplate templateWcellLc = readExcel("classpath:templates/template_wcell_lc" +
            ".xlsx");
        DatabuildSheetGolden goldenWcellWB = new DatabuildSheetGolden(new XSSFWorkbook(new
            ByteArrayInputStream(newSiteCreation.getGoldenParametersWcell())));


        setRncID(newSiteCreation, templateWcellLc, 0);
        setWbtsId(newSiteCreation, templateWcellLc, 1);
        setTemplateName(newSiteCreation, templateWcellLc, 3);
        setLcrid(newSiteCreation, templateWcellLc, 2);


        goldenWcellWB.getGoldenParamsMap().forEach((paramName, paramValue) -> {
            int colIndex = templateWcellLc.getColumnIndex().getOrDefault(paramName, Integer
                .MIN_VALUE);
            if (colIndex >= 0) {
                templateWcellLc.setCellValue(0, 1, colIndex, (int) Double.parseDouble(paramValue));
            }
        });


        newSiteCreation.setOutputWcellLc(templateWcellLc.write());
        newSiteCreation.setOutputWcellLcContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");


    }


    private void populateWcellPc(NewSiteCreation newSiteCreation) throws IOException {
        DatabuildSheetTemplate templateWcellPc = readExcel("classpath:templates/template_wcell_pc" +
            ".xlsx");
        DatabuildSheetGolden goldenWcellWB = new DatabuildSheetGolden(new XSSFWorkbook(new
            ByteArrayInputStream(newSiteCreation.getGoldenParametersWcell())));


        setRncID(newSiteCreation, templateWcellPc, 0);
        setWbtsId(newSiteCreation, templateWcellPc, 1);
        setTemplateName(newSiteCreation, templateWcellPc, 3);
        setLcrid(newSiteCreation, templateWcellPc, 2);


        goldenWcellWB.getGoldenParamsMap().forEach((paramName, paramValue) -> {
            int colIndex = templateWcellPc.getColumnIndex().getOrDefault(paramName, Integer
                .MIN_VALUE);
            if (colIndex >= 0) {
                templateWcellPc.setCellValue(0, 1, colIndex, (int) Double.parseDouble(paramValue));
            }
        });


        newSiteCreation.setOutputWcellPc(templateWcellPc.write());
        newSiteCreation.setOutputWcellPcContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");


    }

    private void populateWcellPS(NewSiteCreation newSiteCreation) throws IOException {
        DatabuildSheetTemplate templateWcellPS = readExcel("classpath:templates/template_wcell_ps" +
            ".xlsx");
        DatabuildSheetGolden goldenWcellWB = new DatabuildSheetGolden(new XSSFWorkbook(new
            ByteArrayInputStream(newSiteCreation.getGoldenParametersWcell())));


        setRncID(newSiteCreation, templateWcellPS, 0);
        setWbtsId(newSiteCreation, templateWcellPS, 1);
        setTemplateName(newSiteCreation, templateWcellPS, 3);
        setLcrid(newSiteCreation, templateWcellPS, 2);


        goldenWcellWB.getGoldenParamsMap().forEach((paramName, paramValue) -> {
            int colIndex = templateWcellPS.getColumnIndex().getOrDefault(paramName, Integer
                .MIN_VALUE);
            if (colIndex >= 0) {
                templateWcellPS.setCellValue(0, 1, colIndex, (int) Double.parseDouble(paramValue));
            }
        });


        newSiteCreation.setOutputWcellPS(templateWcellPS.write());
        newSiteCreation.setOutputWcellPSContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");


    }

    private void populateWcellSib(NewSiteCreation newSiteCreation) throws IOException {
        DatabuildSheetTemplate templateWcellSib = readExcel
            ("classpath:templates/template_wcell_sib.xlsx");
        DatabuildSheetGolden goldenWcellWB = new DatabuildSheetGolden(new XSSFWorkbook(new
            ByteArrayInputStream(newSiteCreation.getGoldenParametersWcell())));


        setRncID(newSiteCreation, templateWcellSib, 0);
        setWbtsId(newSiteCreation, templateWcellSib, 1);
        setTemplateName(newSiteCreation, templateWcellSib, 3);
        setLcrid(newSiteCreation, templateWcellSib, 2);


        goldenWcellWB.getGoldenParamsMap().forEach((paramName, paramValue) -> {
            int colIndex = templateWcellSib.getColumnIndex().getOrDefault(paramName, Integer
                .MIN_VALUE);
            if (colIndex >= 0) {
                templateWcellSib.setCellValue(0, 1, colIndex, (int) Double.parseDouble(paramValue));
            }
        });


        newSiteCreation.setOutputWcellSib(templateWcellSib.write());
        newSiteCreation.setOutputWcellSibContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");


    }

    private void populateWcellUraid(NewSiteCreation newSiteCreation) throws IOException {
        DatabuildSheetTemplate templateWcellUraid = readExcel
            ("classpath:templates/template_wcell_uraid.xlsx");
        DatabuildSheetGolden goldenWcellWB = new DatabuildSheetGolden(new XSSFWorkbook(new
            ByteArrayInputStream(newSiteCreation.getGoldenParametersWcell())));


        setRncID(newSiteCreation, templateWcellUraid, 0);
        setWbtsId(newSiteCreation, templateWcellUraid, 1);
        setTemplateName(newSiteCreation, templateWcellUraid, 4);
        setLcrid(newSiteCreation, templateWcellUraid, 2);


        goldenWcellWB.getGoldenParamsMap().forEach((paramName, paramValue) -> {
            int colIndex = templateWcellUraid.getColumnIndex().getOrDefault(paramName, Integer
                .MIN_VALUE);
            if (colIndex >= 0) {
                templateWcellUraid.setCellValue(0, 1, colIndex, (int) Double.parseDouble
                    (paramValue));
            }
        });


        newSiteCreation.setOutputWcellUraid(templateWcellUraid.write());
        newSiteCreation.setOutputWcellUraidContentType("application/vnd" +
            ".openxmlformats-officedocument.spreadsheetml.sheet"                      );


    }

    private void populateWlcse(NewSiteCreation newSiteCreation) throws IOException {
        if(null == newSiteCreation.getGoldenParametersWlcse()){
            return;
        }
        DatabuildSheetTemplate templateWlcse = readExcel("classpath:templates/template_wlcse.xlsx");
        DatabuildSheetGolden goldenWlcseWB = new DatabuildSheetGolden(new XSSFWorkbook(new
            ByteArrayInputStream(newSiteCreation.getGoldenParametersWlcse())));


        setRncID(newSiteCreation, templateWlcse, 0);
        setTemplateName(newSiteCreation, templateWlcse, 2);
        templateWlcse.setCellValue(0, 1, 1, newSiteCreation.getWlcseId());
        templateWlcse.setCellValue(0, 1, 4, newSiteCreation.getAntBearing());
        templateWlcse.setCellValue(0, 1, 16, newSiteCreation.getWlcseRncId());
        templateWlcse.setCellValue(0, 1, 17, newSiteCreation.getAntennaCoordLatitude());
        templateWlcse.setCellValue(0, 1, 18, newSiteCreation.getAntennaCoordLongitude());
        templateWlcse.setCellValue(0, 1, 20, newSiteCreation.getSiteName());


        goldenWlcseWB.getGoldenParamsMap().forEach((paramName, paramValue) -> {
            int colIndex = templateWlcse.getColumnIndex().getOrDefault(paramName, Integer
                .MIN_VALUE);
            if (colIndex >= 0) {
                templateWlcse.setCellValue(0, 1, colIndex, (int) Double.parseDouble(paramValue));
            }
        });


        newSiteCreation.setOutputWlcse(templateWlcse.write());
        newSiteCreation.setOutputWlcseContentType(newSiteCreation
            .getGoldenParametersWlcseContentType());


    }

    private void populateWbts(NewSiteCreation newSiteCreation) throws IOException {
        if(null == newSiteCreation.getGoldenParametersWbts()){
            return;
        }
        File file = ResourceUtils.getFile("classpath:templates/template_wbts.xlsx");
        InputStream in = new FileInputStream(file);

        FileInputStream excelFile = new FileInputStream(file);
        DatabuildSheetTemplate templateWbtsWB = new DatabuildSheetTemplate(new XSSFWorkbook
            (excelFile));
        DatabuildSheetGolden goldenWbtsWB = new DatabuildSheetGolden(new XSSFWorkbook(new
            ByteArrayInputStream
            (newSiteCreation.getGoldenParametersWbts())));
        setRncID(newSiteCreation, templateWbtsWB, 0);
        setWbtsId(newSiteCreation, templateWbtsWB, 1);
        setTemplateName(newSiteCreation, templateWbtsWB, 2);
        setWbtsName(newSiteCreation, templateWbtsWB, 109);


        goldenWbtsWB.getGoldenParamsMap().forEach((paramName, paramValue) -> {
            int colIndex = templateWbtsWB.getColumnIndex().getOrDefault(paramName, Integer
                .MIN_VALUE);
            if (colIndex >= 0) {
                templateWbtsWB.setCellValue(0, 1, colIndex, (int) Double.parseDouble(paramValue));
            }
        });

        newSiteCreation.setOutputWbts(templateWbtsWB.write());
        newSiteCreation.setOutputWbtsContentType(newSiteCreation
            .getGoldenParametersWbtsContentType());
    }

    private void setWbtsName(NewSiteCreation newSiteCreation, DatabuildSheetTemplate
        templateWbtsWB, int cellIndex) {
        templateWbtsWB.setCellValue(0, 1, cellIndex, newSiteCreation.getWbtsName());
    }

    private void setTemplateName(NewSiteCreation newSiteCreation, DatabuildSheetTemplate
        templateWbtsWB, int cellIndex) {
        templateWbtsWB.setCellValue(0, 1, cellIndex, newSiteCreation.getTemplateName());
    }

    private void setWbtsId(NewSiteCreation newSiteCreation, DatabuildSheetTemplate
        templateWbtsWB, int cellIndex) {
        templateWbtsWB.setCellValue(0, 1, cellIndex, newSiteCreation.getWbtsId());
    }


    private void setCid(NewSiteCreation newSiteCreation, DatabuildSheetTemplate template, int
        cellIndex) {
        template.setCellValue(0, 1, cellIndex, newSiteCreation.getcId());
    }

    private void setLcrid(NewSiteCreation newSiteCreation, DatabuildSheetTemplate template, int
        cellIndex) {
        template.setCellValue(0, 1, cellIndex, newSiteCreation.getLcrId());
    }

    private void setRncID(NewSiteCreation newSiteCreation, DatabuildSheetTemplate template, int
        cellIndex) {
        template.setCellValue(0, 1, cellIndex, newSiteCreation.getRncId());
    }

    private DatabuildSheetTemplate readExcel(String s) throws IOException {
        File file = ResourceUtils.getFile(s);
        InputStream in = new FileInputStream(file);
        FileInputStream excelFile = new FileInputStream(file);
        return new DatabuildSheetTemplate(new XSSFWorkbook(excelFile));
    }

}
