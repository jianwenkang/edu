package com.crown.servlet.shiro;

/**
 * @ClassName User
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2019/11/8
 * @Time 11:48
 * @Version 1.0
 */
public enum User {

    admin(Role.admin, "admin", "admin"),  //管理员账号
    guest(Role.user, "user", "user"); //普通用户账号

    Role role;
    String username;
    String password;

    User(Role role, String username, String password) {
        this.role = role;
        this.username = username;
        this.password = password;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

}
