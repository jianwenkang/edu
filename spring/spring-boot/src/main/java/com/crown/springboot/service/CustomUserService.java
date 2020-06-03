package com.crown.springboot.service;


import com.crown.springboot.dao.PermissionDao;
import com.crown.springboot.dao.UserDao;
import com.crown.springboot.entity.Permission;
import com.crown.springboot.entity.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName CustomUserService
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2020-06-02
 * @Time 11:12
 * @Version 1.0
 */
@Service
public class CustomUserService implements UserDetailsService { //自定义UserDetailsService 接口



    @Autowired
    private UserDao userDao;

    @Autowired
    private PermissionDao permissionDao;


    @Override
    public UserDetails loadUserByUsername(String username) {

        SysUser user = userDao.findByUserName(username);

        if (user != null) {

            List<Permission> permissions = permissionDao.findByAdminUserId(user.getId());

            List<GrantedAuthority> grantedAuthorities = new ArrayList<>();

            for (Permission permission : permissions) {

                if (permission != null && permission.getName() != null) {



                    GrantedAuthority grantedAuthority = new MyGrantedAuthority(permission.getUrl(), permission.getMethod());

                    grantedAuthorities.add(grantedAuthority);

                }

            }

            return new User(user.getUsername(), user.getPassword(), grantedAuthorities);

        } else {

            throw new UsernameNotFoundException("admin: " + username + " do not exist!");

        }

    }



}
