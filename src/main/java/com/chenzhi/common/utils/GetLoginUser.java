package com.chenzhi.common.utils;

import com.chenzhi.domain.dto.LoginUser;

import javax.servlet.http.HttpServletRequest;


public class GetLoginUser {

    public static void setLoginUserNameInSession(HttpServletRequest httpServletRequest,LoginUser loginUser){
        httpServletRequest.getSession().setAttribute("loginUser",loginUser);
    }

    public static LoginUser getLoginUserNameInSession(HttpServletRequest httpServletRequest){
        return (LoginUser)httpServletRequest.getSession().getAttribute("loginUser");
    }
}
