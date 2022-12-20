package com.chenzhi.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.chenzhi.common.Enum.order.OrderStatusEnum;
import com.chenzhi.common.Enum.order.PaymentEnum;
import lombok.Data;

/**
 * 
 * @TableName sys_order
 */
@TableName(value ="sys_order")
@Data
public class SysOrder implements Serializable {
    /**
     * 订单Id
     */
    @TableId(type = IdType.AUTO)
    private Long orderId;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 地址薄ID-发货
     */
    private Long sendId;

    /**
     * 地址薄ID-收货
     */
    private Long collectId;

    /**
     * 网点Id-1
     */
    private Long startnetdot;

    /**
     * 网点Id-2
     */
    private Long endnetdot;

    /**
     * 货物名称
     */
    private String goodsNames;

    /**
     * 货物包装
     */
    private String goodsPack;

    /**
     * 件数
     */
    private Integer num;

    /**
     * 重量
     */
    private BigDecimal weigth;

    /**
     * 体积
     */
    private BigDecimal volume;

    /**
     * 备注
     */
    private String remark;

    /**
     * 0已撤销,1未受理，2已受理，3已开单，4已签收
     */
    private OrderStatusEnum orderStatus;

    /**
     * 下单时间
     */
    private Date createOrderTime;

    /**
     * 投保价值
     */
    private BigDecimal valueInsured;

    /**
     * 代收货款
     */
    private BigDecimal goodsPayment;

    /**
     * 付款方式
     */
    private PaymentEnum payment;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}