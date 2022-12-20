package com.chenzhi.controller;

import com.chenzhi.common.utils.GetLoginUser;
import com.chenzhi.common.utils.Result;
import com.chenzhi.domain.dto.LoginBody;
import com.chenzhi.domain.dto.UserRegistration;
import com.chenzhi.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/user")
public class SysUserController {

    @Resource
    private UserServiceImpl sysUserService;

    //用户登录
    @PostMapping("/login")
    public Result login(@RequestBody LoginBody loginBody){
        String token = sysUserService.login(loginBody.getUsername(),loginBody.getPassword());
        return Result.success(200,"获取token",token);
    }
    //获取个人信息
    @GetMapping("getUserInfo")
    public Result getUserInfo(HttpServletRequest request){
        //先获取个人的userId
        Long userId = GetLoginUser.getLoginUserNameInSession(request).getUserId();
        return sysUserService.getUserInfo(userId);
    }
    //用户注册
    @PostMapping("registration")
    public Result registration(@RequestBody UserRegistration userRegistration){
        return sysUserService.registration(userRegistration);
    }
}
