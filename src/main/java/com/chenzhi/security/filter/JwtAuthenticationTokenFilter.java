package com.chenzhi.security.filter;

import com.alibaba.fastjson2.JSON;
import com.chenzhi.common.utils.GetLoginUser;
import com.chenzhi.common.utils.TokenService;
import com.chenzhi.domain.dto.LoginUser;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;


/**
 * OncePerRequestFilter过滤器在UserPasswordAuthenticationFilter的前面
 */
@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    @Resource
    private TokenService tokenService;

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        //1.获取到token
        String token = request.getHeader("token");
        if(!StringUtils.hasText(token)){
             //token都没有就直接放行
//            OncePerRequestFilter过滤器在UserPasswordAuthenticationFilter的前面
            //所以在放行之后走UserPasswordAuthenticationFilter让用户去登陆
            filterChain.doFilter(request,response);
            return;//这里的return是不走下面的代码
        }
        //2.解析Token
        Claims claims = null;
        String uuid=null;
        try {
            claims = tokenService.parseToken(token);
            uuid = (String)claims.get("login_user_key");
            System.out.println(uuid);
        } catch (Exception exception) {
            exception.printStackTrace();
            new RuntimeException();
        }
        //3.从Redis里面获取用户信息
        ValueOperations<String, String> stringStringValueOperations = stringRedisTemplate.opsForValue();
        String loginUserJson = stringStringValueOperations.get("login_tokens:"+uuid);
        LoginUser loginUser = JSON.parseObject(loginUserJson, LoginUser.class);
        if(Objects.isNull(loginUser)){
            new RuntimeException("用户未登录！");
        }
        GetLoginUser.setLoginUserNameInSession(request,loginUser);
        // 4. 后续的拦截器会判断你是否以认证过了（）所以要将信息存入SecurityContextHolder
        //credentials:临时的凭证 aurthors：权限集合暂时为null
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(loginUser,null,null);
        SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
        //放行
        filterChain.doFilter(request,response);
    }
}
