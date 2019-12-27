package com.crown.excel;


import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

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
        xssf.writerExcle();
    }

    public void writerExcle() throws IOException {
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook();
        xssfWorkbook.createSheet();


        xssfWorkbook.write(new FileOutputStream(new File(file + System.currentTimeMillis() +".xlsx")));

    }
}
