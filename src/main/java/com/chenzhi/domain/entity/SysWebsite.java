package com.chenzhi.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

import com.chenzhi.common.Enum.website.CategoryEnum;
import lombok.Data;

/**
 * 
 * @TableName sys_website
 */
@TableName(value ="sys_website")
@Data
public class SysWebsite implements Serializable {
    /**
     * 网点id
     */
    @TableId(type = IdType.AUTO)
    private Long websiteId;

    /**
     * 网点省份
     */
    private String websiteProvince;

    /**
     * 网点市
     */
    private String websiteCity;

    /**
     * 网点区
     */
    private String websiteRegion;

    /**
     * 手机
     */
    private String phone;

    /**
     * 电话（座机）
     */
    private String tel;

    /**
     * 详细地址
     */
    private String detailedAddress;

    /**
     * 送货类别
     */
    private CategoryEnum category;

    /**
     * 省市区码
     */
    private String code;

    /**
     * 网点名称
     */
    private String websiteName;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}