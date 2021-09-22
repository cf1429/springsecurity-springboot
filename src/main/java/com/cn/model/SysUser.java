package com.cn.model;

import lombok.Data;

/**
 * @Author:chenf
 * @Date:2021/9/22 22:53
 * @describe
 */
@Data
public class SysUser {
    private String id;
    private String username;
    private String password;
    private String nickName;
    private String mobile;
}
