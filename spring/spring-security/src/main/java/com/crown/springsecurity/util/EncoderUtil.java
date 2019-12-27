package com.crown.springsecurity.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @ClassName EncoderUtil
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2019/3/20
 * @Time 18:33
 * @Version 1.0
 */
public class EncoderUtil {

    public static String md5Encoder(String str) {
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("md5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        byte[] digest = md5.digest(str.getBytes());
        return util(digest).toString();
    }

    public static String shaEncoder(String str) {
        MessageDigest sha = null;
        try {
            sha = MessageDigest.getInstance("sha");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        byte[] digest = sha.digest(str.getBytes());
        return util(digest).toString();
    }

    public static String base64(String username,String password){

        return null;
    }

    public static void main(String[] args) {

    }

    public static StringBuffer util(byte[] digest){
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
