package com.chenzhi.controller;

import com.alibaba.fastjson2.JSON;
import com.chenzhi.common.utils.GetLoginUser;
import com.chenzhi.common.utils.Result;
import com.chenzhi.common.utils.TokenService;
import com.chenzhi.domain.dto.LoginUser;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
public class TestController {

    @Autowired
    private TokenService tokenService;

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @GetMapping("/test")
    public Result test(HttpServletRequest request){
        return Result.success("用户id为"+ GetLoginUser.getLoginUserNameInSession(request).getUserId());
    }
}
