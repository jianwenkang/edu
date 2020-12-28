package com.crown.excel;


import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

/**
 * @ClassName Xssf
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2019/8/19
 * @Time 19:04
 * @Version 1.0
 */
public class Xssf {
    String file = "F:\\crownProjects\\edu\\test\\office\\src\\main\\resources\\";

    public static void main(String[] args) throws IOException {
        Xssf xssf = new Xssf();

        xssf.readExcle();
    }
    public void readExcle() throws IOException {
        InputStream in=new FileInputStream(file + "\\1597373572121.xlsx");//创建一个输入流读取单元格
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(in);
        int numberOfSheets = xssfWorkbook.getNumberOfSheets();//获得Excel有几个sheet页面
        for (int sheetNum = 0; sheetNum < numberOfSheets; sheetNum++){
            XSSFSheet sheet =  xssfWorkbook.getSheetAt(sheetNum);//获得具体的Sheet
            int firstRowNum = sheet.getFirstRowNum();
            int lastRowNum = sheet.getLastRowNum();
            for (int rowNum = 0; rowNum <= lastRowNum; rowNum++){
                XSSFRow row = sheet.getRow(rowNum);//获得行
                short firstCellNum = row.getFirstCellNum();
                short lastCellNum = row.getLastCellNum();
                for (int cellNum = 0; cellNum < lastCellNum; cellNum++){
                    System.out.println(row.getCell(cellNum));
                }

            }

        }

    }
    public void writerExcle() throws IOException {
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook();
        xssfWorkbook.createSheet();


        xssfWorkbook.write(new FileOutputStream(new File(file + System.currentTimeMillis() +".xlsx")));

    }
}
