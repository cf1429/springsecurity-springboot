package com.cn.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.cn.dao.SysUserMapper;
import com.cn.model.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    SysUserMapper sysUserMapper;
    // 根据账号查询用户信息
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        //将来要连接数据库查找用户信息
        LambdaQueryWrapper<SysUser> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(SysUser::getUsername,s);
        SysUser sysUser = sysUserMapper.selectOne(lambdaQueryWrapper);
        // 暂时采用模拟数据
        System.out.println("调用自定义的UserDetailsService");
        UserDetails authorities = User.withUsername("zhangsan").password("$2a$10$JiKeZ5WY6LMm1LnVTgQUPO11sBf.nWd/OWubgnmtXL03uOWWVDYSS").authorities("p1").build();
        return authorities;
    }
}
