package com.crown.servlet.shiro;

/**
 * @ClassName Role
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2019/11/8
 * @Time 11:48
 * @Version 1.0
 */
public enum Role {

    //管理员角色有 CRUD权限
    admin("admin", Permission.select,Permission.update,Permission.delete,Permission.insert),
    //普通用户只有查看权限
    user("guest", Permission.select);

    String roleName;
    Permission[] permission;
    Role(String roleName, Permission... permission){
        this.roleName = roleName;
        this.permission = permission;
    }

    public String getRoleName() {
        return roleName;
    }
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
    public Permission[] getPermission() {
        return permission;
    }
    public void setPermission(Permission[] permission) {
        this.permission = permission;
    }
}

