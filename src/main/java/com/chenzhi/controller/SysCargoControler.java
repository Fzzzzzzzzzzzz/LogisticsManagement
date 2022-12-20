package com.chenzhi.controller;


import com.chenzhi.common.utils.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/cargo")
public class SysCargoControler {

    @GetMapping("getGoodsNames")
    public Result getGoodsNames(){
        List<String> goodsNamesList = new ArrayList<>();
        goodsNamesList.add("日用品");
        goodsNamesList.add("家用家电");
        goodsNamesList.add("数码产品");
        goodsNamesList.add("食品饮料");
        goodsNamesList.add("设备及材料");
        goodsNamesList.add("服装鞋帽");
        goodsNamesList.add("其他");
        return Result.success(200,"获取货物名称成功！",goodsNamesList);
    }

    @GetMapping("getGoodsPack")
    public Result getGoodsPack(){
        List<String> goodsPackList = new ArrayList<>();
        goodsPackList.add("包装袋");
        goodsPackList.add("裸装");
        goodsPackList.add("膜");
        goodsPackList.add("木架");
        goodsPackList.add("纤袋");
        goodsPackList.add("信封");
        return Result.success(200,"获取货物打包方式成功！",goodsPackList);
    }

    @GetMapping("getSendGoodsType")
    public Result getSendGoodsType(){
        List<String> sendGoodsTypeList = new ArrayList<>();
        sendGoodsTypeList.add("自提");
        sendGoodsTypeList.add("送货上门");
        sendGoodsTypeList.add("送货上楼");
        return Result.success(200,"获取货物名称成功！",sendGoodsTypeList);
    }

    @GetMapping("getReturnSlip")
    public Result getReturnSlip(){
        List<String> returnSlipList = new ArrayList<>();
        returnSlipList.add("不签回单");
        returnSlipList.add("原件返回");
        returnSlipList.add("传真返回");
        return Result.success(200,"获取货物名称成功！",returnSlipList);
    }
}
