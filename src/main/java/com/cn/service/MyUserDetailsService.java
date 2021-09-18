package com.cn.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @Author:chenf
 * @Date:2021/9/16 18:22
 * @describe
 */
@Service
public class MyUserDetailsService implements UserDetailsService {


    // 根据账号查询用户信息
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        //将来要连接数据库查找用户信息

        // 暂时采用模拟数据
        System.out.println("调用自定义的UserDetailsService");
        UserDetails authorities = User.withUsername("zhangsan").password("1234").authorities("p1").build();
        return authorities;
    }
}
