package com.chenzhi.controller;


import com.chenzhi.common.utils.GetLoginUser;
import com.chenzhi.common.utils.Result;
import com.chenzhi.domain.entity.SysOrder;
import com.chenzhi.service.impl.SysOrderServiceImpl;
import com.chenzhi.service.impl.SysWebsiteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("order")
public class SysOrderController {

    @Resource
    private SysOrderServiceImpl sysOrderService;

    /**
     *获取个人所有的订单
     */
    @GetMapping("getAllOrders")
    public Result getAllOrders(HttpServletRequest request){
        //先获取个人的userId
        Long userId = GetLoginUser.getLoginUserNameInSession(request).getUserId();
        return sysOrderService.getAllOrders(userId);
    }

    /**
     *新增订单
     */
    @PostMapping("addOrder")
    public Result addOrder(@RequestBody SysOrder sysOrder,
                           HttpServletRequest request){
        Long userId = GetLoginUser.getLoginUserNameInSession(request).getUserId();
        sysOrder.setUserId(userId);
        //对象需要校验，暂时不管
        if(!ObjectUtils.isEmpty(sysOrder)){
            return sysOrderService.addOrder(sysOrder);
        }
        return Result.fail(400,"订单为空！",null);
    }

    /**
     *修改订单状态
     */
    @PutMapping("/updateOrder/{orderId}")
    public Result updateOrder(@PathVariable("orderId") Long orderId){
        return sysOrderService.updateOrder(orderId);
    }
}
