package com.crown.word;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

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

    public static void main(String[] args) {

    }

    public void writerWorld() throws IOException {
        POIFSFileSystem poifsFileSystem = new POIFSFileSystem();
        HWPFDocument hwpfDocument = new HWPFDocument(poifsFileSystem);



    }
}
