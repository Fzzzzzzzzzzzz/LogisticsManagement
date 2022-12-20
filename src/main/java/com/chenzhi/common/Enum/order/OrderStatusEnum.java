package com.chenzhi.common.Enum.order;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;

public enum OrderStatusEnum {


    Withdrawn(0,"已撤销"),
    NotAccepted(1,"未受理"),
    Accepted(2,"已受理"),
    AlreadyOrder(3,"已开单"),
    SignedAndReceived(4,"已签收");

    @EnumValue
    private Integer enumKey;

    @JsonValue
    private String display;

    OrderStatusEnum(Integer enumKey, String display) {
        this.enumKey = enumKey;
        this.display = display;
    }

    public Integer getKey() {
        return enumKey;
    }

    public String getDisplay() {
        return display;
    }
}
