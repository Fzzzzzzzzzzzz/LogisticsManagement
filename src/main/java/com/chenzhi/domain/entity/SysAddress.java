package com.chenzhi.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName sys_address
 */
@TableName(value ="sys_address")
@Data
public class SysAddress implements Serializable {
    /**
     * 地址薄id
     */
    @TableId(type = IdType.AUTO)
    private Long addressId;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 联系人姓名
     */
    private String myname;

    /**
     * 详细地址
     */
    private String detailedAddress;

    /**
     * 电话号码
     */
    private String phoneNumber;

    /**
     * 省市区号码
     */
    private String code;

    /**
     * 收发货人；1发货人，2为收货人
     */
    private Integer collectOrsend;

    /**
     * 是否为默认地址，
     */
    private Integer isDefault;

    /**
     * 市
     */
    private String city;

    /**
     * 省份
     */
    private String province;

    /**
     * 区
     */
    private String region;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}