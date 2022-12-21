package com.chenzhi.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chenzhi.common.Enum.order.OrderStatusEnum;
import com.chenzhi.common.utils.Result;
import com.chenzhi.domain.entity.SysAddress;
import com.chenzhi.domain.entity.SysOrder;
import com.chenzhi.service.SysOrderService;
import com.chenzhi.mapper.SysOrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.Clock;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
* @author 86199
* @description 针对表【sys_order】的数据库操作Service实现
* @createDate 2022-12-18 19:35:56
*/
@Service
public class SysOrderServiceImpl extends ServiceImpl<SysOrderMapper, SysOrder>
    implements SysOrderService{

    @Resource
    private SysOrderMapper sysOrderMapper;

    //获取个人所有的订单
    @Override
    public Result getAllOrders(Long userId) {
        LambdaQueryWrapper<SysOrder> sysAddressQueryWrapper = new LambdaQueryWrapper<>();
        sysAddressQueryWrapper.eq(SysOrder::getUserId,userId);
        List<SysOrder> sysOrderList= sysOrderMapper.selectList(sysAddressQueryWrapper);
        if(sysOrderList.size()==0)
            Result.success(400,"个人所有的订单为空！",null);
        return Result.success(200,"获取个人所有的订单成功！",sysOrderList);
    }

    //新增订单
    @Override
    public Result addOrder(SysOrder sysOrder) {
        sysOrder.setCreateOrderTime(new Date());
        int insert = sysOrderMapper.insert(sysOrder);
        if (insert>0)
            return Result.success(200,"新增订单成功！",null);
        return Result.fail(400,"新增订单失败！" ,null);
    }

    //修改订单状态
    @Override
    public Result updateOrder(Long orderId) {
        SysOrder sysOrder = sysOrderMapper.selectById(orderId);
        if(sysOrder.getOrderId()==1){
            sysOrder.setOrderStatus(OrderStatusEnum.Withdrawn);
            sysOrderMapper.updateById(sysOrder);
            return Result.success(200,"修改订单状态成功！",null);
        }
        return Result.fail(400,"修改订单状态失败！",null);
    }
}




