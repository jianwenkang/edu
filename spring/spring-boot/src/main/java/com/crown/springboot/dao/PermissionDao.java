package com.crown.springboot.dao;

import com.crown.springboot.entity.Permission;

import java.util.List;

/**
 * @ClassName PermissionDao
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2020-06-02
 * @Time 11:10
 * @Version 1.0
 */
public interface PermissionDao {

    public List<Permission> findAll();

    public List<Permission> findByAdminUserId(int userId);

}
