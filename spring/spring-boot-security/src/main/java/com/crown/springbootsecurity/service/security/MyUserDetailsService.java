package com.crown.springbootsecurity.service.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

/**
 * @ClassName MyUserDetailsService
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2019/12/24
 * @Time 16:54
 * @Version 1.0
 */

@Service
public class MyUserDetailsService implements UserDetailsService {
    private static Logger logger = LoggerFactory.getLogger(MyUserDetailsService.class);
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.info("授权");
        // 这里应该根据用户名查询用户信息 信息包含角色及权限
        Collection<GrantedAuthority> authorities = new ArrayList<>();
		if(Objects.equals(username,"admin") || Objects.equals(username,"user")){
			logger.info("用户名存在");
		}else {
            logger.info("用户名不存在");
            throw new UsernameNotFoundException("用户名不存在");
        }
        UserDetails user = null;
        if(username.equals("admin")){
            authorities.add(new SimpleGrantedAuthority("ADMIN"));
            authorities.add(new SimpleGrantedAuthority("USER"));
            user = new User("admin", new BCryptPasswordEncoder().encode("admin"), authorities);

        }
        if(username.equals("user")){
            authorities.add(new SimpleGrantedAuthority("USER"));
            user = new User("user", "$2a$10$lVuT6zs72Ia3YX3rVB1MOu8u/Rc0d0BLE79jXiNilElFNhTzbqcFW", authorities);
        }
        // 返回UserDetails实现类
        return user;
    }
}
