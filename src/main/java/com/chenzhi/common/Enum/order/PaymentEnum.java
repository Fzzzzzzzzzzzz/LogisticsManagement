package com.chenzhi.common.Enum.order;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;

public enum PaymentEnum {

    FreightCollectPayment(1,"到付"),
    SpotPayment(2,"现付");

    @EnumValue
    private Integer enumKey;

    @JsonValue
    private String display;

    PaymentEnum(Integer enumKey, String display) {
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

