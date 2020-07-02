package com.crown.factory.simple;

/**
 * @ClassName MainboardFactory
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2020-07-02
 * @Time 16:26
 * @Version 1.0
 */
public class MainboardFactory {
    public static Mainboard createMainboard(int type) {
        Mainboard mainboard = null;
        if (type == 1) {
            mainboard = new IntelMainboard(755);
        } else if (type == 2) {
            mainboard = new AmdMainboard(938);
        }
        return mainboard;
    }
}
