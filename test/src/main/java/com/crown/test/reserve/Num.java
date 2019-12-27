package com.crown.test.reserve;

import org.junit.Test;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Num
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2019/8/8
 * @Time 13:59
 * @Version 1.0
 */
public class Num {
    @Test
    public void test1(){
        int i = 0b11111111111111111111111111111111;
        int i1 = 0b10110011100011110000111110000011;
        int tem = i1 >> 8;
        System.out.println(tem);
        System.out.println(0b101100111000111100001111);
        System.out.println(Integer.toBinaryString(tem));

        int j = 0b01001100011100001111000001111100;
        int tem1 = j >> 8;
        System.out.println(tem1);
        System.out.println(0b010011000111000011110000);
        System.out.println(Integer.toBinaryString(tem1));

        System.out.println(0xF);
        System.out.println(0xFF);
        System.out.println(0xFFF);
        System.out.println(0xFFFF);

        int i2 = 0b10000000000000000000000000000000;
        System.out.println(i2);
    }

    @Test
    public void test2(){
        int i = 0b10110011100011110000111110000011;
        System.out.println(Integer.toBinaryString(i>>8));
        System.out.println(Integer.toBinaryString(i/2));
        int[] is1 = new int[10];
        int[] is2 = new int[]{1,2,3};
        int[] is3 = {1,2,3};
        byte[] bs = {1,2,3};
        BigInteger bigInteger = new BigInteger(bs);
        byte[] bytes = bigInteger.toByteArray();
        for (byte b:bytes
             ) {
            System.out.println(b);
        }

    }
    @Test
    public void test3(){
        int i = 0b10110011100011110000111110000011;

        int j = 0b01001100011100001111000001111100;

        int k = 0b10000000000000000000000000000000;

        System.out.println(Integer.toBinaryString(4));
        System.out.println(Integer.toBinaryString(~4));
        System.out.println(Integer.toBinaryString(~4)+1);
    }

    @Test
    public void test4(){
        int s = 0b1000000000000000;
        System.out.println((short)s);
    }

    @Test
    public void test5(){
        String str = "王雪";
        char[] strChar=str.toCharArray();
        String result="";
        for(int i=0;i<strChar.length;i++){
            result +=Integer.toBinaryString(strChar[i])+ " ";
        }
        System.out.println(result);

    }

    @Test
    public void test6(){
        short s = 0b0000111110000011;

        int i = 0b10110011100011110000111110000011;
        ArrayList<Byte> bytes = splitInt(i);
        for (Byte b:bytes
             ) {
            System.out.println(b);
        }

        int combine = combine(new byte[]{-77, -113, 15, -125});
        System.out.println(Integer.toBinaryString(combine));
    }

    @Test
    public void test11(){
        byte[] bs = {1,2,3};
        System.out.println(bs.length);
        byte[] bs1 = {0,1,3,5,11,17,20};//不会大于
        oidAlarm(24,bs,bs1);
    }
    private void oidAlarm(int alarmNum,byte[] bs,byte[] bs1){
        byte b;
        int len = bs.length;
        for (int i = 0; i < bs1.length; i++){
            b = bs1[i];
            int num = b/8;
            int off = b%8;
            System.out.println("num:"+num + " off:"+off);
            byte b1 = bs[num];
            System.out.println(b1);

        }
    }

    private static ArrayList<Byte> splitInt(int a) { //int拆分成四个byte方法
        /**
         * 01100101 01100101 00100111 01011101
         * 直接写一个拆分方法
         */
        byte c = 0;
        ArrayList<Byte> list = new ArrayList<>(4); //将四个byte放进集合
        for(int i=0;i<4;i++) {
            c = (byte) (a>>>8*(3-i));
            list.add(c); //添加数据
        }
        return list;
    }

    private static int combine(byte[] num) { //四个byte合并为一个int方法
        /**
         *
         * 01111110 01000010 01001000 01011101
         *    126       66      72       93
         */
        int c = 0;
        for (int i = 0; i < num.length; i++) {

            c += (num[i]<<8*(3-i));
        }
        return c;

    }
    @Test
    public void test12(){
        //                                                      0    1    2
        BigInteger bigInteger = new BigInteger(new byte[]{-77, -113,15,-125,-16,63,-128,-1});//16
        System.out.println(bigInteger);
        byte[] bytes = bigInteger.toByteArray();
        for (int i = 0; i <bytes.length/2;i++) {
            bytes[i] ^= bytes[bytes.length-1-i];
            bytes[bytes.length-1-i] ^= bytes[i];
            bytes[i] ^= bytes[bytes.length-1-i];
        }
        for (byte tmp:bytes) {
            System.out.print(tmp+"\t");
        }
        //System.out.println(b & (1 << 0));

    }

    @Test
    public void test13(){
        BigInteger bigInteger = new BigInteger(new byte[]{-77, -113,15,-125,-16,63,-128,-1});
        byte b = 1;
        BigInteger bigInteger1 = new BigInteger("1");
        System.out.println(bigInteger.toByteArray().length);
    }

    @Test
    public void test14(){
        int i = 0b10110011100011110000111110000011;
        //10110011100011110000111110000011    10000011
        //101100111000111100001111            00001111
        //1011001110001111                    10001111
        //10110011                            10110011
        for (int j = 0; j < 4; j++){
            int b =  (byte) i;
            i = i >>> 8;
            System.out.println(b);
            System.out.println(i);
        }

    }

    public List<Byte> getBytes(){
        ArrayList<Byte> bytes = new ArrayList<>();




        return bytes;
    }

}