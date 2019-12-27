package com.crown.test.number;

import java.io.*;

/**
 * @ClassName Test
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2019/4/9
 * @Time 23:17
 * @Version 1.0
 */
public class Test {

    public static void main(String[] args) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        dataOutputStream.writeByte(120);//1
        dataOutputStream.writeShort(220);//2
        dataOutputStream.writeInt(1111111);//4
        dataOutputStream.writeLong(111l);//8
        dataOutputStream.writeDouble(1.1);//8
        dataOutputStream.writeFloat(2.1f);//4
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        DataInputStream dataInputStream = new DataInputStream(byteArrayInputStream);
        System.out.println(byteArrayInputStream.available());
        System.out.println(dataInputStream.readByte());
        System.out.println(dataInputStream.readShort());
        System.out.println(dataInputStream.readInt());
        System.out.println(dataInputStream.readLong());
        System.out.println(dataInputStream.readDouble());
        System.out.println(dataInputStream.readFloat());

    }
}
