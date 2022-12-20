package com.chenzhi.common.Enum.website;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;

public enum CategoryEnum {

    ExtractBySelf(1,"自提"),
    PickUpGoodsAtHome(2,"提货上门"),
    DeliveryUpstairs(3,"送货上楼");

    @EnumValue
    private Integer enumKey;

    @JsonValue
    private String display;

    CategoryEnum(Integer enumKey, String display) {
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
