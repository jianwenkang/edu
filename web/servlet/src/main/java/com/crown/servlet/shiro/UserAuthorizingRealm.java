package com.crown.servlet.shiro;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Component;

/**
 * @ClassName UserAuthorizingRealm
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2019/11/8
 * @Time 11:50
 * @Version 1.0
 */
@Component
public class UserAuthorizingRealm extends AuthorizingRealm {

//  @Autowired
//  XxxService service;

    /**
     * 认证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        System.out.println("\r\n ===reaml认证处理===");

        UsernamePasswordToken upToken = (UsernamePasswordToken)token;
        String username = upToken.getUsername();
        String password = new String(upToken.getPassword());

        /** 模拟从数据库根据用户名称获取对应的user */
        User loginUser = null;
        if(User.admin.getUsername().equals(username)) {
            loginUser = User.admin;
        }else if(User.guest.getUsername().equals(username)) {
            loginUser = User.guest;
        }else {
            throw new UnknownAccountException("认证失败！！！没有改账号。。。。");
        }

        System.out.println(username + ":::" + password);
        //校验密码
        if(!loginUser.getPassword().equals(password))
            throw new IncorrectCredentialsException("认证失败！！！密码错误。。。。");

        //返回认证信息
        return new SimpleAuthenticationInfo(username, password, getName());
    }



    /**
     * 受权
     * 注意：受权方法是当前用户访问权限资源的时候才会调用的
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

        System.out.println("\r\n ===reaml受权处理===");

        //获取在认证过程中传入的“主要认证信息”
        String username = (String) getAvailablePrincipal(principals);

        /** 模拟从数据库根据用户名称获取对应的user */
        User loginUser = null;
        if(User.admin.getUsername().equals(username)) {
            loginUser = User.admin;
        }else if(User.guest.getUsername().equals(username)) {
            loginUser = User.guest;
        }

        // 创建受权信息对象
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        // 设置当前用户的角色
        System.out.println("当前用户有以下角色");
        System.out.println("-----" + loginUser.getRole().getRoleName() + "-----");
        info.addRole(loginUser.getRole().getRoleName()); // amdin 和 guest

        // 设置当前用户的权限
        Permission[] permissions = loginUser.getRole().getPermission(); // crud四个权限
        System.out.println("当前用户有以下权限");
        for (Permission perm : permissions) {
            System.out.println("-----" + perm.getPermissionName() + "-----");
            info.addStringPermission(perm.getPermissionName());
        }

        return info;
    }


}
