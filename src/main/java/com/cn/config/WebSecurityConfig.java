package com.cn.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 * @Author:chenf
 * @Date:2021/9/16 14:32
 * @describe springsecurity配置文件
 */
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    // 定义用户信息服务（查询用户信息）
//    @Bean
//    public UserDetailsService userDetailsService(){
//        // 基于内存的方式查询用户信息,创建模拟用户张三，李四，并且给张三李四设置分别设置p1，p2的访问权限
//        InMemoryUserDetailsManager memoryUserDetailsManager = new InMemoryUserDetailsManager();
//        memoryUserDetailsManager.createUser(User.withUsername("zhangsan").password("1234").authorities("p1").build());
//        memoryUserDetailsManager.createUser(User.withUsername("lisi").password("1234").authorities("p2").build());
//        return memoryUserDetailsManager;
//    }


    // 密码编译器
    @Bean  // 先采用不需要密码算法对密码进行对比的方式进行密码的比较，这里表示单纯的使用字符串的对比的方式进行比较。
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }

    // 安全拦截机制，根据目前项目模拟需要，添加需要放行的请求和需要认证通过的请求
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/test/test1").hasAnyAuthority("p1")  // 拥有p1权限，可以访问test1
                .antMatchers("/test/test2").hasAnyAuthority("p2")  // 拥有p2权限，可以访问test2
                .antMatchers("/test/**").authenticated()   // 这个请求必须认证通过
                .anyRequest().permitAll()   // 除了上面的请求，其他的都可以放行、
                .and()
                .formLogin()// 允许表单登录
                .successForwardUrl("/login-success"); // 自定义登录成功之后的页面地址
    }
}
