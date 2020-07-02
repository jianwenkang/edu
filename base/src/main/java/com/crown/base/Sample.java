package com.crown.base;

/**
 * @ClassName Sample
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2020-07-02
 * @Time 16:04
 * @Version 1.0
 */
public class Sample {
    public static void main(String[] args) {
        try {
            try {
                throw new X();
            } catch (Y e) {
                System.out.println("1Y");
                throw e;
            }
        } catch (Y e) {
            System.out.println("Y");
            return;
        } catch (X e){
            System.out.println("X");
            return;
        } catch (Exception e){
            System.out.println("E");
            return;
        } finally {
            System.out.println("OK");
        }
    }
}

class X extends Exception{}
class Y extends X{}
