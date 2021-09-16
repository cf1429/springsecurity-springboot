package com.cn.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @Author:chenf
 * @Date:2021/9/14 16:01
 * @describe
 */
@RestController
public class LoginController {
    /**
     * springsecurity支持form表单认证，认证成功后跳转到/login-success
     * 定义登录成功访问页面
     * @return
     */
    @RequestMapping(value = "/login-success")
    public String loginSuccess(){
        return "登录成功了";

    }
    /*
      * 测试session会话，通过从session中获取用户信息来判断是否登录过
     * @param httpSession
     * @return
             */
    @RequestMapping(value = "/test/test1" )
    public String test1(HttpSession httpSession){
        String fullname = null;


        return fullname+"访问资源";
    }


    /**
     * 测试session会话，通过从session中获取用户信息来判断是否登录过
     * @param httpSession
     * @return
     */
    @RequestMapping(value = "/test/test2" )
    public String test2(HttpSession httpSession){
        String fullname = null;
        return fullname+"访问资源";
    }

}
