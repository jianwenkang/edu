package com.crown.servlet.shiro;

/**
 * @ClassName Permission
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2019/11/8
 * @Time 11:47
 * @Version 1.0
 */
public enum Permission {

    select("select"),update("update"),delete("delete"),insert("insert");

    String permissionName;
    private Permission(String permissionName) {
        this.permissionName = permissionName;
    }
    public String getPermissionName() {
        return permissionName;
    }
    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }
}
