package com.crown.word;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * @ClassName Hwpf
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2019/8/19
 * @Time 19:05
 * @Version 1.0
 */
public class Hwpf {

    public static void main(String[] args) throws Exception {
        Hwpf hwpf = new Hwpf();
        hwpf.writerWorld();
    }

    public void writerWorld() throws IOException {

        POIFSFileSystem poifsFileSystem = new POIFSFileSystem(new FileInputStream(""));
        HWPFDocument doc = new HWPFDocument(poifsFileSystem);// 创建Word文件

        doc.write();
    }
}
