package com.chenzhi.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName sys_cargo
 */
@TableName(value ="sys_cargo")
@Data
public class SysCargo implements Serializable {
    /**
     * 
     */
    @TableId
    private Long cargoId;

    /**
     * 
     */
    private Object goodsNames;

    /**
     * 
     */
    private Object goodsPack;

    /**
     * 发货类别
     */
    private Object sendGoodsType;

    /**
     * 代签回单
     */
    private Object returnSlip;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}