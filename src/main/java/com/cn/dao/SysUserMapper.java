package com.cn.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cn.model.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @Author:chenf
 * @Date:2021/9/22 22:57
 * @describe
 */
@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {
}
