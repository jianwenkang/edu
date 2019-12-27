package com.crown.distributed.nio.channel;

import org.junit.Test;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @ClassName TestChannel
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2019/3/16
 * @Time 12:59
 * @Version 1.0
 */
public class TestChannel {
    @Test
    public void testBio() throws Exception {
        File file = new File("F:\\crownProjects\\edu\\distributed\\src\\test\\java\\com\\crown\\distributed\\nio\\channel\\home.html");
        FileInputStream fileInputStream = new FileInputStream(file);
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        while (bufferedReader.ready()){
            System.out.println(bufferedReader.readLine());
        }

    }
    @Test
    public void testNio01() throws Exception {
        File file = new File("F:\\crownProjects\\edu\\distributed\\src\\test\\java\\com\\crown\\distributed\\nio\\channel\\home.html");
        FileInputStream fileInputStream = new FileInputStream(file);
        FileChannel fileChannel = fileInputStream.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate((int) file.length());
        fileChannel.read(byteBuffer);
        byteBuffer.flip();
        System.out.println(new String(byteBuffer.array()));
    }
    @Test
    public void testNio02() throws Exception {
        File file = new File("F:\\crownProjects\\edu\\distributed\\src\\test\\java\\com\\crown\\distributed\\nio\\channel\\home.html");
        FileInputStream fileInputStream = new FileInputStream(file);
        FileChannel channel = fileInputStream.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(10);

        while (0 < channel.read(byteBuffer)){
            byteBuffer.flip();
            System.out.print(new String(byteBuffer.array()));
            byteBuffer.clear();
        }
    }

    @Test
    public void testNio03() throws Exception {
        File file = new File("F:\\crownProjects\\edu\\distributed\\src\\test\\java\\com\\crown\\distributed\\nio\\channel\\home.html");
        FileInputStream fileInputStream = new FileInputStream(file);
        FileChannel channel = fileInputStream.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(10);
        System.out.println(byteBuffer);
        while (0 < channel.read(byteBuffer)){
            String s = new String(byteBuffer.array());
            System.out.print(s);
            byteBuffer.clear();
        }
    }

    @Test
    public void testNio04() throws Exception {
        File file = new File("F:\\crownProjects\\edu\\distributed\\src\\test\\java\\com\\crown\\distributed\\nio\\channel\\home1.html");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        FileChannel channel = fileOutputStream.getChannel();
        String str = "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Title1</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "    <h1>title</h1>\n" +
                "</body>\n" +
                "</html>";
        ByteBuffer wrap = ByteBuffer.wrap(str.getBytes());
        int write = channel.write(wrap);
    }

    @Test
    public void test05() throws Exception {
        RandomAccessFile rf = new RandomAccessFile("F:\\crownProjects\\edu\\distributed\\src\\test\\java\\com\\crown\\distributed\\nio\\channel\\home1.html", "rw");
        FileChannel channel = rf.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(100);
        int read = channel.read(byteBuffer);
        while (read != -1){
            System.out.println(read);
            byteBuffer.flip();
            while (byteBuffer.hasRemaining()){
                System.out.println((char)byteBuffer.get());
            }
            byteBuffer.clear();
            read = channel.read(byteBuffer);
        }
        rf.close();
    }
}
