package com.chenzhi.domain.dto;

import lombok.Data;

public class UserRegistration {

    /**
     * 用户账号
     */
    private String userName;


    /**
     * 用户昵称
     */
    private String nickName;


    /**
     * 密码
     */
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
