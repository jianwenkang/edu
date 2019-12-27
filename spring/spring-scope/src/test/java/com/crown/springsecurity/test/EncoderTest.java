package com.crown.springsecurity.test;

import org.junit.Test;

import java.security.MessageDigest;

/**
 * @ClassName EncoderUtil
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2019/3/20
 * @Time 17:58
 * @Version 1.0
 */
public class EncoderTest {
    @Test
    public void md5Encoder() throws Exception {
        MessageDigest md5 = MessageDigest.getInstance("md5");
        byte[] digest = md5.digest("".getBytes());//digest.length == 16w位
        System.out.println(digest.length);
        System.out.println(util(digest));
    }
    @Test
    public void shaEncoder() throws Exception {
        MessageDigest sha = MessageDigest.getInstance("sha");
        byte[] digest = sha.digest("jimispassword".getBytes());
        System.out.println(digest.length);
        System.out.println(util(digest));
    }

    public StringBuffer util(byte[] digest){
        StringBuffer sb = new StringBuffer();
        for (byte b:digest // c -128 <= b <= 127
        ) {
            int temp = b;
            int a = temp & 0xff;//0 <= i <= 255
            if(a<16){
                sb.append(0);
            }
            sb.append(Integer.toHexString(a));
        }
        return sb;
    }
}
