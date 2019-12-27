package com.crown.distributed.nio.buffer;

import org.junit.Test;

import java.nio.Buffer;
import java.nio.ByteBuffer;

/**
 * @ClassName TestBuffer
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2019/3/16
 * @Time 11:00
 * @Version 1.0
 */
public class TestBuffer {
    @Test
    public void test01(){
        Buffer buffer = null;
        ByteBuffer byteBuffer = ByteBuffer.allocate(10);
        byte b = 0;
        while (byteBuffer.hasRemaining()){
            byteBuffer.put(++b);
            System.out.println(byteBuffer);
        }
        byteBuffer.flip();//切换模式
        while (byteBuffer.hasRemaining()){
            System.out.println(byteBuffer + ":"+ byteBuffer.get());
        }
    }
    @Test
    public void test02(){
        Buffer buffer = null;
        ByteBuffer byteBuffer = ByteBuffer.allocate(10);
        byteBuffer.put((byte) 1);
        byteBuffer.put((byte) 2);
        byteBuffer.put((byte) 3);
        byteBuffer.flip();
        System.out.println(byteBuffer);
        System.out.println(byteBuffer.get());//1
        System.out.println(byteBuffer);
        //byteBuffer.flip();
        byteBuffer.compact();
        System.out.println(byteBuffer);
        byteBuffer.putChar((char) 4);
        while (byteBuffer.hasRemaining()){
            System.out.println(byteBuffer.get());
        }
    }
    @Test
    public void test03(){
        Buffer buffer = null;
        ByteBuffer byteBuffer = ByteBuffer.allocate(10);
        byte b = 0;
        while (byteBuffer.hasRemaining()){
            System.out.println(byteBuffer);
            byteBuffer.put(++b);
        }
        byteBuffer.clear();
        byteBuffer.flip();//切换模式
        while (byteBuffer.hasRemaining()){
            System.out.println(byteBuffer + ":"+ byteBuffer.get());
        }
    }
    @Test
    public void test04(){
        String str = "adc";
        ByteBuffer wrap = ByteBuffer.wrap(str.getBytes());//返回的为read模式
        while (wrap.hasRemaining()){
            System.out.println(wrap.get());
        }
    }
    @Test
    public void test05(){
        String str = "adc";
        ByteBuffer wrap = ByteBuffer.wrap(str.getBytes());//返回的为read模式
        byte[] array = wrap.array();
        System.out.println(new String(array));
    }
    @Test
    public void test06(){
        String str = "adc";
        ByteBuffer byteBuffer = ByteBuffer.wrap(str.getBytes());//返回的为read模式
        byteBuffer.position(1);
        System.out.println(byteBuffer);
        ByteBuffer newByteBuffer = byteBuffer.slice();
        System.out.println(newByteBuffer);
    }
}
