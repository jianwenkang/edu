package com.crown.springbootsecurity.service.security;

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
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Collection<GrantedAuthority> authorities = new ArrayList<>();
		/*if(){
			throw new UsernameNotFoundException("用户名不存在");
		}*/
        UserDetails user = null;
        if(username.equals("admin")){
            authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
            authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
            user = new User("admin", new BCryptPasswordEncoder().encode("admin"), authorities);

        }
        if(username.equals("user")){
            authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
            user = new User("user", "$2a$10$lVuT6zs72Ia3YX3rVB1MOu8u/Rc0d0BLE79jXiNilElFNhTzbqcFW", authorities);
        }
        // 返回UserDetails实现类
        return user;
    }
}
