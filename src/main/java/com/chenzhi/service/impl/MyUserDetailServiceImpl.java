package com.chenzhi.service.impl;

import com.chenzhi.domain.dto.LoginUser;
import com.chenzhi.domain.entity.SysUser;
import com.chenzhi.mapper.UserMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;

@Service
public class MyUserDetailServiceImpl implements UserDetailsService {

    @Resource
    private UserMapper userMapper;


    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        SysUser sysUser = userMapper.loadUserByUsername1(userName);
        if (ObjectUtils.isEmpty(sysUser))
            throw new UsernameNotFoundException("用户名不正确！");
        //查询对应的权限信息


        LoginUser loginUser = new LoginUser();
        loginUser.setUserId(sysUser.getUserId());
        loginUser.setUser(sysUser);
        return loginUser;
    }
}
