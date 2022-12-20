package com.chenzhi.domain.entity;

import com.alibaba.fastjson2.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 用户信息表
 * @TableName sys_user
 */
@TableName(value ="sys_user")
@Data
public class SysUser implements Serializable {
    /**
     * 用户ID
     */
    @TableId(type = IdType.AUTO)
    private Long userId;

    /**
     * 用户账号
     */
    private String userName;


    /**
     * 用户昵称
     */
    private String nickName;


    /**
     * 头像地址
     */
    private String avatar;

    /**
     * 密码
     */
    @JSONField(serialize = false)
    private String password;


    /**
     * 余额
     */
    @JSONField(serialize = false)
    private double money;


    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}