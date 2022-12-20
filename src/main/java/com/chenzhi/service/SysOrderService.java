package com.chenzhi.service;

import com.chenzhi.common.utils.Result;
import com.chenzhi.domain.entity.SysOrder;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author 86199
* @description 针对表【sys_order】的数据库操作Service
* @createDate 2022-12-18 19:35:56
*/
public interface SysOrderService extends IService<SysOrder> {

    Result getAllOrders(Long userId);

    Result addOrder(SysOrder sysOrder);

    Result updateOrder(Long orderId);
}
