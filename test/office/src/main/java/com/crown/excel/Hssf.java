package com.crown.excel;

import org.apache.poi.hssf.extractor.ExcelExtractor;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

/**
 * @ClassName Hssf
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2019/8/19
 * @Time 19:01
 * @Version 1.0
 */
public class Hssf {

    static String file = "F:\\crownProjects\\edu\\test\\office\\src\\main\\resources\\";

    public static void main(String[] args) throws Exception {
        Hssf hssf = new Hssf();
        //hssf.writerExcel();
        //hssf.readrExcel1();
        //hssf.readrExcel2();
        hssf.readrExcel3();
    }

    private void writerExcel(){
        Workbook wk=new HSSFWorkbook();//定义一个工作薄
        Sheet aaa = wk.createSheet("aaa");//定义一个指定名称的sheet
        Row row = aaa.createRow(0);//创建第一行
        Cell cell = row.createCell(0);//创建第一行的第一个单元格
        cell.setCellValue("1-A");//为第一行第一个单元格塞值
        cell = row.createCell(1);//创建第一行的第一个单元格
        cell.setCellValue("1-B");//为第一行第二个单元格塞值

        row = aaa.createRow(1);//创建第二行
        cell = row.createCell(0);
        cell.setCellValue("2-A");
        cell = row.createCell(2);
        cell.setCellValue("2-C");

        Sheet sheet = wk.createSheet();//定义一个没有名称的Sheet
        row = sheet.createRow(0);
        cell = row.createCell(0);
        cell.setCellValue("1-A");
        try {
            FileOutputStream out = new FileOutputStream(file + System.currentTimeMillis() +".xls");
            wk.write(out);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void readrExcel1() throws Exception {
        InputStream in=new FileInputStream(file + "\\test.xls");//创建一个输入流读取单元格
        POIFSFileSystem pfs =new POIFSFileSystem(in);
        HSSFWorkbook hwb=new HSSFWorkbook(pfs);
        ExcelExtractor excelExtractor=new ExcelExtractor(hwb);//提取文本
        excelExtractor.setIncludeSheetNames(false);//不需要sheet页名字
        System.out.println(excelExtractor.getText());
        in.close();
    }

    private void readrExcel2() throws Exception {
        InputStream in=new FileInputStream(file + "\\test.xls");//创建一个输入流读取单元格
        POIFSFileSystem pfs = new POIFSFileSystem(in);
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(pfs);
        HSSFSheet sheet = hssfWorkbook.getSheetAt(0);//根据下标获得相关sheet
        HSSFRow row = sheet.getRow(0);
        HSSFCell cell = row.getCell(0);
        String cellValue = cell.getStringCellValue();
        System.out.print(cellValue);
        cell = row.getCell(1);
        cellValue = cell.getStringCellValue();
        System.out.println("  "+cellValue);
        row = sheet.getRow(1);
        cell = row.getCell(0);
        cellValue = cell.getStringCellValue();
        System.out.print(cellValue);
        cell = row.getCell(2);
        cellValue = cell.getStringCellValue();
        System.out.println("  "+cellValue);
        in.close();
    }

    private void readrExcel3() throws Exception {
        InputStream in=new FileInputStream(file + "\\test.xls");//创建一个输入流读取单元格
        POIFSFileSystem pfs = new POIFSFileSystem(in);
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(pfs);
        int numberOfSheets = hssfWorkbook.getNumberOfSheets();//获得有几页
        for (int i = 0; i < numberOfSheets; i++){
            HSSFSheet sheet = hssfWorkbook.getSheetAt(i);
            int rowNum = sheet.getLastRowNum();////最后一行行标，比行数小1
            for (int j = 0; j < rowNum +1; j++){
                HSSFRow row = sheet.getRow(j);
                if(row == null){
                    continue;
                }
                int cellNum = row.getPhysicalNumberOfCells();//是获取不为空的列个数
                short cellNum1 = row.getLastCellNum();//是获取最后一个不为空的列是第几个
                for (int k = 0; k < cellNum1; k++){
                    HSSFCell cell = row.getCell(k);
                    if(cell == null){
                        System.out.print("|NaN|");
                        continue;
                    }
                    System.out.print(cell.getStringCellValue() != null &&  cell.getStringCellValue() != "" ? "|"+cell.getStringCellValue()+"|": "|NNN|");
                }
                System.out.println();
            }
        }

        in.close();
    }
}
