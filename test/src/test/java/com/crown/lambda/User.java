package com.crown.lambda;

/**
 * @ClassName User
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2019/4/1
 * @Time 13:25
 * @Version 1.0
 */
public class User {
    private Integer idInteger;

    private String descString;

    private Integer alarmTypeInteger;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return idInteger.equals(user.idInteger) &&
                descString.equals(user.descString) &&
                alarmTypeInteger.equals(user.alarmTypeInteger);
    }


}
